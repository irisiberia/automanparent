package com.automan.siberia.factorytest.simplefactory;

/**
 * @Author: he.zhou
 * @Date: 2019-04-11
 */
public class Test {
    public static void main(String[] args) {
        IceCreamFactory.getIceCream("1").taste();
        IceCreamFactory.getIceCream("2").taste();
    }
}
