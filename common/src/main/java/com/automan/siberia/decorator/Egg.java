package com.automan.siberia.decorator;

/**
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
public class Egg extends Condiment {
    private Food food;

    public Egg(Food food) {
        this.food = food;
    }

    @Override
    public String getDesc() {
        return food.setDesc()+"加蛋";
    }

    @Override
    public double cost() {
        return food.cost()+7;
    }
}
