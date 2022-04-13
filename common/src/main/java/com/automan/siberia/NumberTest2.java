package com.automan.siberia;

public class NumberTest2 {

    private static int num = 1;

    private void test1() {

        while (num <= 100) {
            synchronized (this) {
                if (num % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "=====" + num);
                    num++;
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


    private void test2() {

        while (num <= 100) {
            synchronized (this) {
                if (num % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "=====" + num);
                    num++;
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
        NumberTest2 numberTest2=new NumberTest2();
        new Thread(()->numberTest2.test1()).start();
        new Thread(()->numberTest2.test2()).start();
    }


}
