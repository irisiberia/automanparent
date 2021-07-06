package com.automan.siberia;

public class StaticTest1 extends StaticTest {

    private int number;

    //静态代码块
    static {
        System.out.println("StaticTest1 静态代码块执行！");
    }

    //构造代码块
    {
        System.out.println("StaticTest1 构造代码块执行！");
        number = 1;
    }

    //构造方法
    public StaticTest1() {
        System.out.println("StaticTest1 构造方法执行！");
        System.out.println(number);
    }

    private static void t() {
        System.out.println("StaticTest1 静态方法");
    }

    public static void main(String[] args) {
        new StaticTest1();
    }

}
