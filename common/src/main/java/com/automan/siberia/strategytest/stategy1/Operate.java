package com.automan.siberia.strategytest.stategy1;

/**
 * @Author: he.zhou
 * @Date: 2019-04-12
 */
public class Operate {
    private Strategy strategy;

    public Operate(Strategy strategy) {
        this.strategy = strategy;
    }

    public int doOperate(int i, int a) {
        return strategy.doOperation(i, a);
    }
}
