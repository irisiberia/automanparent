package com.automan.fill;

import com.automan.bean.DictAo;
import com.automan.bean.SkuTypeDictFillable;

import com.automan.root.utils.fill.FreeStyleFiller;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author he.zhou
 * @date 2020/1/9
 **/
@Component
public class SkuTypeDictFiller implements FreeStyleFiller<SkuTypeDictFillable> {

    @Override
    public void multiFill(Collection<SkuTypeDictFillable> collection) {
        AtomicInteger i = new AtomicInteger();
        Map<Integer, DictAo> map = collection.stream().map(ar -> {
            DictAo dictAo = new DictAo();
            dictAo.setName("测试类型" + ar.getSkuType());
            dictAo.setOrder(0);
            dictAo.setType(ar.getSkuType());
            return dictAo;
        }).collect(Collectors.toMap(DictAo::getType, o -> o));

        collection.forEach(ar -> {
            ar.fillSku(map.get(ar.getSkuType()));
        });
    }
}
