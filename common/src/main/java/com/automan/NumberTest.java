package com.automan;

public class NumberTest {
    private static int num = 1;

    public void one() {
        while (true) {
            if (num > 100) {
                break;
            }
            synchronized (this) {
                if (num % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "==" + num);
                    num++;
                    notify();
                }

            }
        }
    }


    public void two() {
        while (true) {
            if (num >= 100) {
                break;
            }
            synchronized (this) {
                if (num % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "==" + num);
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
        NumberTest number2 = new NumberTest();
        new Thread(() -> number2.two()).start();
        new Thread(() -> number2.one()).start();
    }

}
