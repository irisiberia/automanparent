package com.automan.siberia.decorator;

/**
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
public class HotDryNoodel extends Food {

    public HotDryNoodel() {
        desc="热干面";
    }

    @Override
    public double cost() {
        return 11;
    }
}
