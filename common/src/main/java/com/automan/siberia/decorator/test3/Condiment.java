package com.automan.siberia.decorator.test3;

/**
 * 继承自Food，使装饰者与组件拥有共同的超类
 *
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
public abstract class Condiment extends Food {

    protected Food food;

    public Condiment(Food food) {
        this.food = food;
    }

}
