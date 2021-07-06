package com.automan.siberia.abstractTestServe;

/**
 * @Author: he.zhou
 * @Date: 2018-12-24
 */
public abstract class AbstractTest<R> {

    private String ss;

    public AbstractTest(String ss) {
        this.ss = ss;
    }


    public AbstractTest() {
    }

    public abstract void start();

    protected abstract R end();

    protected int step(int a, int b) {
        return a + b;
    }

    public String error() {
        return "发生错误";
    }



    public R doResult() {
        System.out.println(step(2, 5));
        return this.end();
    }

}
