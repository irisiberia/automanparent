package com.automan.siberia.threadlocalTest;

/**
 * @Author: he.zhou
 * @Date: 2019-02-13
 */
public class Test {
    private static  ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {

        new qwqw() {
            @Override
            public void get() {
                System.out.println("接口测试类");
            }
        }.get();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        if (threadLocal.get() == null) {
                            threadLocal.set("ThreadA" + (i+1));
                            System.out.println(i+1);
                        } else {
                            System.out.println("ThreadA get Value=" + threadLocal.get());
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread() {
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        if (threadLocal.get() == null) {
                            threadLocal.set("ThreadB" + (i + 1));
                        } else {
                            System.out.println("ThreadB get Value=" + threadLocal.get());
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}