package com.automan.siberia.java8InterfaceTest;

/**
 * @Author: he.zhou
 * @Date: 2019-04-10
 */
public class Test {
    public static void main(String[] args) {
        Window window=new Window1Impl();
        window.set("dd").set("sss");
        window.activated();
         ((Window1Impl) window).sin();
    }
}
