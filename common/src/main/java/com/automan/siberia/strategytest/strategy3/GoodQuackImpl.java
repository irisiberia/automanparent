package com.automan.siberia.strategytest.strategy3;

/**
 * @author he.zhou
 * @date 2019/9/14
 **/
public class GoodQuackImpl implements QuackBehavier {
    @Override
    public void quack() {
        System.out.println("叫的很好听");
    }
}
