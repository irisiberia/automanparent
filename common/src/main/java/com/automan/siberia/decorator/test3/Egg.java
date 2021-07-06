package com.automan.siberia.decorator.test3;

/**
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
public class Egg extends Condiment {


    public Egg(Food food) {
        super(food);
    }

    @Override
    public String decs() {
        return food.decs() + "鸡蛋";
    }

    @Override
    public double cost() {
        return food.cost() + 7;
    }
}
