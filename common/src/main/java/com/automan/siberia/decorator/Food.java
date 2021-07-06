package com.automan.siberia.decorator;

/**
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
public abstract class Food {

    protected String desc;

    public String setDesc() {
        return desc;
    }

    public abstract double cost();
}
