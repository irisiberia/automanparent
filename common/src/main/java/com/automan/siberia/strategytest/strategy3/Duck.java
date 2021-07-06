package com.automan.siberia.strategytest.strategy3;

/**
 * @author he.zhou
 * @date 2019/9/14
 **/
public abstract class Duck {

    private FlyBechavier flyBechavier;
    private QuackBehavier quackBehavier;

    public Duck(FlyBechavier flyBechavier, QuackBehavier quackBehavier) {
        this.flyBechavier = flyBechavier;
        this.quackBehavier = quackBehavier;
    }

    protected void process() {
        System.out.println(getColor());
        flyBechavier.fly();
        quackBehavier.quack();
    }

    abstract String getColor();
}
