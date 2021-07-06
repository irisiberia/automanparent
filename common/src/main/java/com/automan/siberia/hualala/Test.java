package com.automan.siberia.hualala;

/**
 * @author he.zhou
 * @date 2019/11/25
 **/
public class Test {

    public static void test(A a) {
        System.out.println(" I am Tset A");
        a.whoAmI();
    }

    public static void test(B b) {
        System.out.println(" I am Tset B");
        b.whoAmI();
    }

    public static void main(String[] args) {
        A a = new B();
        test(a);
    }
}
