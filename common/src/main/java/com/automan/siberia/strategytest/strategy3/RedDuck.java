package com.automan.siberia.strategytest.strategy3;

/**
 * @author he.zhou
 * @date 2019/9/14
 **/
public class RedDuck extends Duck {
    public RedDuck(FlyBechavier flyBechavier, QuackBehavier quackBehavier) {
        super(flyBechavier, quackBehavier);
    }

    @Override
    String getColor() {
        return "红色";
    }

    public static void main(String[] args) {
        RedDuck duck=new RedDuck(new BadFlyImpl(),new GoodQuackImpl());
        duck.process();
    }
}
