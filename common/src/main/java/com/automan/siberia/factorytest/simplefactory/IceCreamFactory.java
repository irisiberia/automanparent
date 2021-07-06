package com.automan.siberia.factorytest.simplefactory;

/**
 * @Author: he.zhou
 * @Date: 2019-04-11
 */
public class IceCreamFactory {

    public static IceCream getIceCream(String type) {
        if (type == "1") {
            return new AppleIceCream();
        }
        if (type == "2") {
            return new BananaIceCream();
        }
        return null;
    }
}
