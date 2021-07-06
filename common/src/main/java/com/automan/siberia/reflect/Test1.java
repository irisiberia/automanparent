package com.automan.siberia.reflect;

import java.lang.reflect.Constructor;

/**
 * @author he.zhou
 * @date 2019/9/22
 **/
public class Test1 {
    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("com.automan.siberia.reflect.MyStudent");
        Constructor constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        MyStudent student= (MyStudent) o;
        student.show();
    }
}
