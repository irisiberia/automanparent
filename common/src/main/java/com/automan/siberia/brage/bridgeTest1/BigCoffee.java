package com.automan.siberia.brage.bridgeTest1;

/**
 * @Author: he.zhou
 * @Date: 2018-12-25
 */
public class BigCoffee extends Coffee {


    //继承默认使用父类的无参的构造方法
    //    //要么父类写一个无参的构造
    //    //要么使用父类有参的构造
    public BigCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯咖啡:" + additives.addSoming());
    }
}
