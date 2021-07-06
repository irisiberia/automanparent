package com.automan.siberia.brage.bridgeTest1;

/**
 * 抽象的Coffee类
 *
 * @Author: he.zhou
 * @Date: 2018-12-25
 */

public abstract class Coffee {

    protected CoffeeAdditives additives;

    public Coffee(CoffeeAdditives additives) {
        this.additives = additives;
    }

    /**
     * 咖啡具体是什么样的由子类决定；
     */
    public abstract void makeCoffee();
}
