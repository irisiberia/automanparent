package com.automan.siberia.abstractOrderService1;

import java.lang.reflect.Field;

/**
 * @author he.zhou
 * @date 2019/9/20
 **/
public class Common {
    public static <T> T getObjectFromWlist(Class<T> clazz) {
        Object bean = null;
        try {
            bean = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) bean;
    }

    public static void main(String[] args) {


    }

}
