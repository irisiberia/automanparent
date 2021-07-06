package com.automan.siberia.decorator.test3;

/**
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
public class Test {

    public static void main(String[] args) {
        Food food = new HotDryNoodel();
        Food food2 = new BeefNoodles();
        Condiment condiment = new Vegetable(new Egg(food2));
        System.out.println(condiment.decs() + condiment.cost());
    }


}
