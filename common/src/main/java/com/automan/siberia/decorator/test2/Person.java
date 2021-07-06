package com.automan.siberia.decorator.test2;

/**
 * @author he.zhou
 * @date 2019/9/17
 **/
public class Person implements Decorator {
    @Override
    public void show() {
        System.out.println("一个人站立");
    }

    public static void main(String[] args) {
        new ShoesDecorator(new Person()).show();
        new TshirtDecorator(new ShoesDecorator(new Person())).show();
        new TshirtDecorator(new ShoesDecorator(new Man())).show();

    }
}
