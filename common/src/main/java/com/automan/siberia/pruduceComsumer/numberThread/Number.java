package com.automan.siberia.pruduceComsumer.numberThread;

/**
 * @author he.zhou
 * @date 2019/12/27
 * 两个线程循环交替打印1到100
 **/
public class Number {
    private int total = 1;

    private void one() {
        while (true) {
            if (total > 100) {
                break;
            }
            synchronized (this) {
                if (total % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "====" + total);
                    total++;
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

    private void even() {
        while (true) {
            if (total > 100) {
                break;
            }
            synchronized (this) {
                if (total % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "====" + total);
                    total++;
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


    public static void main(String[] args) throws InterruptedException {
        Number number = new Number();
        new Thread(number::one).start();
        new Thread(number::even).start();
        Thread.sleep(10000);
    }
}
