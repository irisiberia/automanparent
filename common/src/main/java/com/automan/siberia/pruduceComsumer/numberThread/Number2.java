package com.automan.siberia.pruduceComsumer.numberThread;

public class Number2 {
    private static int num = 100;

    public void one() {
        while (true) {
            if (num <= 0) {
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
                    num--;
                    notify();
                }
            }
        }
    }

    public void two() {
        while (true) {
            if (num <= 0) {
                break;
            }
            synchronized (this) {
                if (num % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "==" + num);
                    num--;
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
        Number2 number2=new Number2();
        new Thread(()->number2.two()).start();
        new Thread(()->number2.one()).start();

    }
}
