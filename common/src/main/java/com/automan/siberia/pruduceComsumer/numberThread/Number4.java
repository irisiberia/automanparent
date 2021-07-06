package com.automan.siberia.pruduceComsumer.numberThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程循环交替打印1到100
 */
public class Number4 {
    private static int num = 1;
    private static int flag = 1;
    private static ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    public void test1() {
        while (num <= 100) {
            lock.lock();
            if (flag == 1) {
                System.out.println(Thread.currentThread().getName() + "===" + num);
                num++;
                flag=2;
                condition1.signal();
            } else {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();

        }

    }

    public void test2() {
        while (num <= 100) {
            lock.lock();
            if (flag == 2) {
                System.out.println(Thread.currentThread().getName() + "===" + num);
                num++;
                flag=3;
                condition2.signal();
            } else {
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();

        }

    }

    public void test3() {
        while (num <= 100) {
            lock.lock();
            if (flag == 3) {
                System.out.println(Thread.currentThread().getName() + "===" + num);
                num++;
                flag=1;
                condition.signal();
            } else {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();

        }

    }


    public static void main(String[] args) {
        Number4 number4=new Number4();
        new Thread(()->number4.test1()).start();
        new Thread(()->number4.test2()).start();
        new Thread(()->number4.test3()).start();

    }


}
