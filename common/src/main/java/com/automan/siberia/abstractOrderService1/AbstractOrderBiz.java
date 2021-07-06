package com.automan.siberia.abstractOrderService1;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;

/**
 * @Author: he.zhou
 * @Date: 2018-12-24
 */
public abstract class AbstractOrderBiz<T> implements OrderBiz<T> {

    private int tableId;

    private Class clz;

    public AbstractOrderBiz() {

        this.clz = (Class<T>)
                ((ParameterizedType) getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    @Override
    public T generate() {
        return toVersionData();
    }

    @Override
    public void update(Class<T> tClass) {

        System.out.println("修改成功");
    }

    @Override
    public T queryById() {
        try {
            Constructor c = clasz().getConstructor(Integer.class, String.class);
            T bean = (T) c.newInstance(1, "测试sdsdsdssdd");
            return bean;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    public T queryByCondition() {
        try {
            Constructor c = clz.getConstructor(Integer.class, String.class);
            T bean = (T) c.newInstance(1, "测试sdsdsdssdd");
            return bean;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    abstract String getOrdrType();

    abstract void generateCheck();

    abstract void endOrder();

    abstract int setTableId();

    abstract T toVersionData();

    abstract Class<T> clasz();

}
