package com.automan.siberia.mianshi2021;

/**
 * @Author he.zhou
 * @Date 2021-07-06
 */
public class NumberTest {
    private static int i = 0;

    public void test1() {
        while (i <= 100) {
            synchronized (this) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "====" + i);
                    i++;
                    try {
                        notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public void test2() {
        while (i <= 100) {
            synchronized (this) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "====" + i);
                    i++;
                    try {
                        notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        NumberTest test = new NumberTest();

        new Thread(() -> test.test1()).start();
        new Thread(() -> test.test2()).start();
    }
}
