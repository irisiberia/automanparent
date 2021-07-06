package com.automan.root.utils.fill;

import com.automan.root.utils.fill.util.GenericUtil;
import com.automan.root.utils.fill.lang.LazyMap;
import com.automan.root.utils.Safes;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: he.zhou
 * @Date: 2019-04-25
 */
@Component
public class FillableResolver {

    @Resource
    private List<Filler> fillers;

    @Resource
    private List<FreeStyleFiller> freeStyleFillers;

    @SuppressWarnings("unchecked")
    private LazyMap<Class, List<Filler>> fillerMap = new LazyMap<Class, List<Filler>>() {
        @Override
        protected List<Filler> load(Class obj) {
            return fillers.stream()
                    .filter(x -> fillerSupportFillableMap.get(x).isAssignableFrom(obj))
                    .collect(Collectors.toList());
        }
    };

    @SuppressWarnings("unchecked")
    private LazyMap<Class, List<FreeStyleFiller>> freeStyleFillerMap = new LazyMap<Class, List<FreeStyleFiller>>() {
        @Override
        protected List<FreeStyleFiller> load(Class obj) {
            return freeStyleFillers.stream()
                    .filter(x -> freeStyleFillerSupportFillableMap.get(x).isAssignableFrom(obj))
                    .collect(Collectors.toList());
        }
    };

    private LazyMap<Filler, Class> fillerSupportFillableMap = new LazyMap<Filler, Class>() {
        @Override
        protected Class load(Filler key) {
            return GenericUtil.getInterfaceFirstGenericClass(key.getClass(), Filler.class);
        }
    };

    private LazyMap<FreeStyleFiller, Class> freeStyleFillerSupportFillableMap = new LazyMap<FreeStyleFiller, Class>() {
        @Override
        protected Class load(FreeStyleFiller key) {
            return GenericUtil.getInterfaceFirstGenericClass(key.getClass(), FreeStyleFiller.class);
        }
    };

    /**
     * 填充单个对象
     * @param bean
     * @param <T>
     */
    public <T> void resolve(T bean) {
        multiResolve(Collections.singletonList(bean));
    }

    /**
     * 填充单个对象，指定填充接口
     * @param bean
     * @param fillableClasses
     * @param <T>
     */
    public <T> void resolve(T bean, Set<Class> fillableClasses) {
        multiResolve(Collections.singletonList(bean), fillableClasses);
    }

    /**
     * 填充单个对象，按指定填充顺序填充
     * @param bean
     * @param fillableClasses
     * @param <T>
     */
    public <T> void sortedResolve(T bean, List<Class> fillableClasses) {
        multiSortedResolve(Collections.singletonList(bean), fillableClasses);
    }

    /**
     * 填充对象集合
     * @param collection
     * @param <T>
     */
    public <T> void multiResolve(Collection<T> collection) {
        multiResolve(collection, null);
    }

    /**
     * 填充对象集合, 指定填充接口
     * @param collection
     * @param fillableClasses
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    public <T> void multiResolve(Collection<T> collection, Set<Class> fillableClasses) {
        if (CollectionUtils.isEmpty(collection)) {
            return;
        }

        T t = Safes.first(collection);
        if (t == null) {
            return;
        }
        Class<?> tClass = t.getClass();

        List<Filler> fillers = Safes.of(fillerMap.get(tClass));
        List<FreeStyleFiller> freeStyleFillers = Safes.of(freeStyleFillerMap.get(tClass));
        if (fillableClasses != null) {
            fillers = fillers.stream()
                    .filter(x -> fillableClasses.stream().map(Class::getTypeName).anyMatch(y -> y.equals(fillerSupportFillableMap.get(x).getTypeName())))
                    .collect(Collectors.toList());
            freeStyleFillers = freeStyleFillers.stream()
                    .filter(x -> fillableClasses.stream().map(Class::getTypeName).anyMatch(y -> y.equals(freeStyleFillerSupportFillableMap.get(x).getTypeName())))
                    .collect(Collectors.toList());
        }

        freeStyleFillers.forEach(x -> x.multiFill(collection));

        Map<Class, HashSet> fillerKeyMap = new HashMap<>(fillers.size());
        for (T item : collection) {
            for (Filler filler : fillers) {
                Object beanKey = filler.getBeanKey(item);
                if (beanKey != null) {
                    HashSet keys = fillerKeyMap.computeIfAbsent(filler.getClass(), k -> new HashSet());
                    keys.add(beanKey);
                }
            }
        }

        Map<Class, Map> dataMap = fillers.stream().collect(Collectors.toMap(Filler::getClass, x -> fillerPrepareData(x, Safes.of(fillerKeyMap.get(x.getClass())))));

        for (T item : collection) {
            for (Filler filler : fillers) {
                Optional.ofNullable(dataMap.get(filler.getClass())).map(x -> x.get(filler.getBeanKey(item))).ifPresent(x -> filler.fill(item, x));
            }
        }
    }

    private <Fillable,K,V> Map<K,V> fillerPrepareData(Filler<Fillable,K,V> filler, Set<K> keys) {
        if (!CollectionUtils.isEmpty(keys)) {
            if (keys.size() > filler.batchSize()) {
                List<K> list = Lists.newArrayList(keys);
                Map<K,V> allDataMap = new HashMap<>(keys.size());
                for (List<K> currentKeys : Lists.partition(list, filler.batchSize())) {
                    allDataMap.putAll(filler.prepareData(Sets.newHashSet(currentKeys)));
                }
                return allDataMap;
            }
            return filler.prepareData(keys);
        }
        return new HashMap<>(0);
    }

    /**
     * 填充对象集合，按照指定填充接口的填充顺序填充. 适用于filler有依赖关系的情况. key-value式填充不再统一遍历集合填充，而是每个filter遍历一次
     * @param collection
     * @param fillableClasses
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    public <T> void multiSortedResolve(Collection<T> collection, List<Class> fillableClasses) {
        if (CollectionUtils.isEmpty(collection)) {
            return;
        }

        T t = Safes.first(collection);
        if (t == null) {
            return;
        }
        Class<?> tClass = t.getClass();

        List<Filler> fillers = Safes.of(fillerMap.get(tClass));
        List<FreeStyleFiller> freeStyleFillers = Safes.of(freeStyleFillerMap.get(tClass));

        for (Class fillableClass : fillableClasses) {
            fillers.stream().filter(x -> fillableClass.getTypeName().equals(fillerSupportFillableMap.get(x).getTypeName())).findFirst().ifPresent(x -> {
                Set keys = collection.stream().map(y -> x.getBeanKey(y)).filter(Objects::nonNull).collect(Collectors.toSet());
                if (!CollectionUtils.isEmpty(keys)) {
                    Map values = fillerPrepareData(x, keys);
                    collection.forEach(y -> {
                        Object value = values.get(x.getBeanKey(y));
                        if (value != null) {
                            x.fill(y, value);
                        }
                    });
                }
            });
            freeStyleFillers.stream().filter(x -> fillableClass.getTypeName().equals(freeStyleFillerSupportFillableMap.get(x).getTypeName()))
                    .findFirst().ifPresent(x -> x.multiFill(collection));
        }
    }

    public void setFillers(List<Filler> fillers) {
        this.fillers = fillers;
    }

    public void setFreeStyleFillers(List<FreeStyleFiller> freeStyleFillers) {
        this.freeStyleFillers = freeStyleFillers;
    }
}
