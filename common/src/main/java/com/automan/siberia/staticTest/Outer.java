package com.automan.siberia.staticTest;

/**
 * @author he.zhou
 * @date 2019/12/24
 **/
public class Outer {
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    static {
        System.out.println("静态代码块");
    }

    private Outer() {
        System.out.println("私有化构造方法");
    }

    public static class Inner {
        public static final Outer outer = new Outer();
    }

    public static Outer getNewInstese() {
        return Inner.outer;
    }

    public static void main(String[] args) {
        System.out.println(Outer.getNewInstese().getCode());
    }
}
