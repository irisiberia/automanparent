package com.automan.siberia.strategytest.strategy3;

/**
 * @author he.zhou
 * @date 2019/9/14
 **/
public class BadFlyImpl implements FlyBechavier {
    @Override
    public void fly() {
        System.out.println("不怎么会飞");
    }
}
