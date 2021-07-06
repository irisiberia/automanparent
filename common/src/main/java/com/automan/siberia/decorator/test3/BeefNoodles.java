package com.automan.siberia.decorator.test3;

/**
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
public class BeefNoodles extends Food {


    @Override
    public String decs() {
        return "牛肉面";
    }

    @Override
    public double cost() {
        return 15;
    }
}
