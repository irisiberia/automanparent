package com.automan.siberia.factorytest.factorymethod;

/**
 * @Author: he.zhou
 * @Date: 2019-04-11
 */
public class Test {

    public static void main(String[] args) {
        IceFactory IceFactory = new AppleIceCreamFactory();
        IceCream iceCream = IceFactory.creatIceCream();
        iceCream.taste();
    }
}
