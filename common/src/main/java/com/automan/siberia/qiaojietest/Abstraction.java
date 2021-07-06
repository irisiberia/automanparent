package com.automan.siberia.qiaojietest;

/**
 * @Author: he.zhou
 * @Date: 2018-10-18
 */
public abstract class Abstraction {

    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 示例方法
     */
    public void operation() {
        implementor.operationImpl();
    }

}
