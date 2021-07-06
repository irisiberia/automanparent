package com.automan.siberia.decorator;

/**
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
public class Vegetable extends Condiment {

    private Food food;

    public Vegetable(Food food) {
        this.food = food;
    }

    @Override
    public String getDesc() {
        return food.setDesc() + "加蔬菜";
    }

    @Override
    public double cost() {
        return food.cost() + 4;
    }
}
