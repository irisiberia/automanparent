package com.automan.siberia.fanshe;

import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Tset {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> cla = Class.forName(String.valueOf("com.automan.siberia.fanshe.Student"));
        Object o = cla.newInstance();
        //下面两种方法是等效的，并注意method.invoke方法参数是可变
        //Method method = cla.getMethod(requestParam,String.class,int.class);
//        method.invoke(o, new Object[] {request  ,response});
        Method method = cla.getMethod("getLsit",List.class,String.class);
        System.out.println(method.invoke(o, Lists.newArrayList("23","232"),"wewe"));
    }
}
