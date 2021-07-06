package com.automan.siberia.pruduceComsumer;

import com.automan.root.utils.util.JsonUtil;

/**
 * @Author: he.zhou
 * @Date: 2019-07-01
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("sssss");
//        Cleck cleck=new Cleck();
        Class claz = Class.forName("com.automan.siberia.pruduceComsumer.Cleck");
        Cleck cleck = (Cleck) claz.newInstance();
        new Thread(new Producer(cleck)).start();
        new Thread(new Comsumer(cleck)).start();
//        System.out.println(JsonUtil.of(cleck));
    }
}
