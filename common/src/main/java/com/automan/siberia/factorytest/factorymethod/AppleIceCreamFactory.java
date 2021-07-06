package com.automan.siberia.factorytest.factorymethod;

/**
 * @Author: he.zhou
 * @Date: 2019-04-11
 */
public class AppleIceCreamFactory implements IceFactory {
    @Override
    public IceCream creatIceCream() {
        return new AppleIceCream();
    }
}
