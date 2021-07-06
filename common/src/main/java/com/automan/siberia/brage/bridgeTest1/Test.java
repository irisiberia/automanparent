package com.automan.siberia.brage.bridgeTest1;

/**
 * @Author: he.zhou
 * @Date: 2018-12-25
 */
public class Test {
    public static void main(String[] args) {
        Sugar sugar = new Sugar();
        Ordinary ordinary = new Ordinary();

        Coffee coffee=new BigCoffee(sugar);
        coffee.makeCoffee();

        MyTest my=new MyTest();
        my.test(sugar);
    }
}
