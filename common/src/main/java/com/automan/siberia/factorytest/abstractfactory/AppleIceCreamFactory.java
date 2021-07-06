package com.automan.siberia.factorytest.abstractfactory;

/**
 * @Author: he.zhou
 * @Date: 2019-04-11
 */
public class AppleIceCreamFactory implements IceCreamFactory {
    @Override
    public BigIceCream creatBig() {
        return new BigAppleIceCream();
    }

    @Override
    public SmallIceCream creatSmall() {
        return new SmallAppleIceCream();
    }
}
