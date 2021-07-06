package com.automan.siberia.decorator.test3;

/**
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
public class Vegetable extends Condiment {

    public Vegetable(Food food) {
        super(food);
    }
    // 可以将超类提到抽象类中
//    private Food food;
//
//    public Vegetable(Food food) {
//        this.food = food;
//    }

    @Override
    public String decs() {
        return food.decs() + "蔬菜";
    }

    @Override
    public double cost() {
        return food.cost() + 4;
    }
}
