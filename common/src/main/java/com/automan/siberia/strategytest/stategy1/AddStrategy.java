package com.automan.siberia.strategytest.stategy1;

/**
 * @Author: he.zhou
 * @Date: 2019-04-12
 */
public class AddStrategy implements Strategy {
    @Override
    public int doOperation(int i, int a) {
        return i + a;
    }
}
