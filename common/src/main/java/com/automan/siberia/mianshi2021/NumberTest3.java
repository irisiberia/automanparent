package com.automan.siberia.mianshi2021;

/**
 * @Author he.zhou
 * @Date 2022-03-07
 */
public class NumberTest3 {
    public static int i = 1;

    public void test() {
        while (i < 100) {
            synchronized (this) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "====" + i);
                    i++;
                    notify();
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


    public void test1() {
        while (i <= 100) {
            synchronized (this) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "====" + i);
                    i++;
                    notify();
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
        NumberTest3 numberTest3 = new NumberTest3();
        new Thread(() -> numberTest3.test()).start();
        new Thread(() -> numberTest3.test1()).start();


    }
}
