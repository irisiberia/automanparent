package com.automan.siberia.decorator;

/**
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
public class Test {
    public static void main(String[] args) {
        Food food = new HotDryNoodel();
        Condiment condiment = new Egg(food);
        System.out.println(condiment.getDesc()+condiment.cost());
    }


}
