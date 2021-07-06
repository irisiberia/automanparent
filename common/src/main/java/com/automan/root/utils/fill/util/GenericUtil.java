package com.automan.root.utils.fill.util;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

/**
 * @Author: he.zhou
 * @Date: 2019-04-25
 */
public class GenericUtil {
    /**
     * 获取指定类的指定接口的第一个范型 如: class A implements B<T> getInterfaceFirstGenericClass(A.class, B.class)= Class.of(T)
     * @param clazz
     * @param interfaceClass
     * @return
     */
    public static Class getInterfaceFirstGenericClass(Class clazz, Class interfaceClass) {
        return getInterfaceGenericClass(clazz, interfaceClass, 0);
    }

    /**
     * 获取指定类的指定接口的第n个范型 如: class A implements B<T1,T2,T3...Tn>  getInterfaceGenericClass(A.class, B.class, n)= Class.of(Tn)
     * @param clazz
     * @param interfaceClass
     * @param n
     * @return
     */
    public static Class getInterfaceGenericClass(Class clazz, Class interfaceClass, int n) {
        return Arrays.stream(clazz.getGenericInterfaces())
                .filter(x -> interfaceClass.getTypeName().equals(((ParameterizedType) x).getRawType().getTypeName()))
                .findFirst()
                .map(x -> {
                    try {
                        return Class.forName(((ParameterizedType) x).getActualTypeArguments()[n].getTypeName());
                    }
                    catch (ClassNotFoundException e) {
                        return null;
                    }
                }).orElse(null);
    }
}
