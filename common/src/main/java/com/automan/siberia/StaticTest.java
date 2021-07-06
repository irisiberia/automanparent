package com.automan.siberia;

public class StaticTest {

    private static String number;

    //静态代码块,在初始化时执行
    static {
        System.out.println("StaticTest 静态代码块执行！");
    }

    //构造代码块
    {
        System.out.println("StaticTest 构造代码块执行！");
//        number = "777";
    }

    //构造方法
    public StaticTest() {
        System.out.println("StaticTest 构造方法执行！");
        System.out.println(number);
    }

    private static void t() {
        System.out.println("StaticTest 静态方法");
    }

    public static void main(String[] args) {
        System.out.println("ssss");
        new StaticTest();
        System.out.println(number);

    }


}
