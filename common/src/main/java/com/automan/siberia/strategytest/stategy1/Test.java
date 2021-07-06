package com.automan.siberia.strategytest.stategy1;

/**
 * @Author: he.zhou
 * @Date: 2019-04-12
 */
public class Test {
    public static void main(String[] args) {
        Strategy strategy= (i, a) -> 333;
        Operate operate=new Operate(new AddStrategy());
        Operate operate1=new Operate(strategy);
        System.out.println(operate.doOperate(3,4));
        System.out.println(operate1.doOperate(3,4));
    }
}
