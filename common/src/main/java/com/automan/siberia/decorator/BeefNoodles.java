package com.automan.siberia.decorator;

/**
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
public class BeefNoodles extends Food {

    public BeefNoodles() {
        desc = "牛肉面";
    }

    @Override
    public double cost() {
        return 15;
    }
}
