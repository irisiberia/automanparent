package com.automan.siberia.decorator.test2;

/**
 * @author he.zhou
 * @date 2019/9/17
 **/
public class TshirtDecorator extends AbstactDecorator {
    public TshirtDecorator(Decorator decorator) {
        super(decorator);
    }

    @Override
    public void show() {
        this.decorator.show();

        System.out.println("穿了一件t-short");
    }
}
