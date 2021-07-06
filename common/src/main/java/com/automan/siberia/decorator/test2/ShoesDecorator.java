package com.automan.siberia.decorator.test2;

/**
 * @author he.zhou
 * @date 2019/9/17
 **/
public class ShoesDecorator extends AbstactDecorator {

    public ShoesDecorator(Decorator decorator) {
        super(decorator);
    }

    @Override
    public void show() {
        decorator.show();
        System.out.println("穿了一双鞋");
    }
}
