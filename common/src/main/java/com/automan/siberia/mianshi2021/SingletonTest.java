package com.automan.siberia.mianshi2021;

/**
 * @Author he.zhou
 * @Date 2021-07-06
 */
public class SingletonTest {
    public static volatile SingletonTest sin;

    private SingletonTest() {
    }

    public static SingletonTest getInstance() {
        if (sin == null) {
            synchronized (SingletonTest.class) {
                if (sin == null) {
                    //被volatil 修饰防止指令重排
                    sin = new SingletonTest();
                }
                return sin;
            }
        }
        return sin;
    }


    public static class inner {
        public static SingletonTest singletonTest = new SingletonTest();
    }
}
