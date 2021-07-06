package com.automan.siberia.threadPool;

/**
 * @Author: he.zhou
 * @Date: 2018-10-17
 */
public class tset {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalTest.set(4);
                System.out.println(ThreadLocalTest.get());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalTest.set(6);
                System.out.println(ThreadLocalTest.get());
            }
        }).start();



    }

}
