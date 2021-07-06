package com.automan.siberia.decorator.test2;

/**
 * @author he.zhou
 * @date 2019/9/17
 **/
public abstract class AbstactDecorator implements Decorator {

    protected Decorator decorator;

    public AbstactDecorator(Decorator decorator) {
        this.decorator = decorator;
    }
}
