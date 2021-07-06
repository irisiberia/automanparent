package com.automan.siberia.pruduceComsumer.numberThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Number3 {
    private static int num = 1;

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    public void one() {
        while (true) {
            if (num > 100) {
                break;
            }
            lock.lock();
            if (num % 2 == 0) {
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ":" + num);
                num++;
                c2.signal();
            }
            lock.unlock();
        }
    }

    public void two() {
        while (true) {
            if (num > 100) {
                break;
            }
            lock.lock();
            if (num % 2 != 0) {
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ":" + num);
                num++;
                c1.signal();
            }
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Number3 number3 = new Number3();
        new Thread(() -> {
            number3.one();
        }).start();
        new Thread(() -> {

            number3.two();
        }).start();
    }
}
