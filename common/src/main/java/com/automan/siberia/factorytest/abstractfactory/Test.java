package com.automan.siberia.factorytest.abstractfactory;

/**
 * @Author: he.zhou
 * @Date: 2019-04-11
 */
public class Test {
    public static void main(String[] args) {
        IceCreamFactory iceCreamFactory=new AppleIceCreamFactory();
        SmallIceCream smallIceCream=iceCreamFactory.creatSmall();
        BigIceCream bigIceCream=iceCreamFactory.creatBig();

        smallIceCream.taste();
        bigIceCream.taste();

    }
}
