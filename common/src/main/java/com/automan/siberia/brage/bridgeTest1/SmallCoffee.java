package com.automan.siberia.brage.bridgeTest1;

/**
 * @Author: he.zhou
 * @Date: 2018-12-25
 */
public class SmallCoffee extends Coffee {


    public SmallCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("小杯咖啡" + additives.addSoming());
    }
}
