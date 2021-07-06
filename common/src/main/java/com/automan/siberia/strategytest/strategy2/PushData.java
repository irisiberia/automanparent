package com.automan.siberia.strategytest.strategy2;

/**
 * @Author: he.zhou
 * @Date: 2019-04-12
 */
public abstract class PushData {

    public void operate() {
        System.out.println(type() + "=====" + pushData());
    }

    abstract int type();

    abstract String pushData();
}
