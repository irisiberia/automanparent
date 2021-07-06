package com.automan.siberia.mianshi2021;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程循环交替打印
 *
 * @Author he.zhou
 * @Date 2021-07-06
 */

public class Number1Test {
    public static int i = 1;
    public static int flag = 1;
    public static final ReentrantLock lock = new ReentrantLock();
    public static final Condition con1 = lock.newCondition();
    public static final Condition con2 = lock.newCondition();
    public static final Condition con3 = lock.newCondition();

    public void test1() {
        while (i <= 100) {
            lock.lock();
            if (flag == 1) {
                System.out.println(Thread.currentThread().getName() + "===" + i);
                i++;
                flag = 2;
                con2.signal();
            } else {
                try {
                    con1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }

    }

    public void test2() {
        while (i <= 100) {
            lock.lock();
            if (flag ==2) {
                System.out.println(Thread.currentThread().getName() + "===" + i);
                i++;
                flag = 3;
                con3.signal();
            } else {
                try {
                    con2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }

    }

    public void test3() {
        while (i <= 100) {
            lock.lock();
            if (flag == 3) {
                System.out.println(Thread.currentThread().getName() + "===" + i);
                i++;
                flag = 1;
                con1.signal();
            } else {
                try {
                    con3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        Number1Test number1Test = new Number1Test();
        new Thread(()->number1Test.test1()).start();
        new Thread(()->number1Test.test2()).start();
        new Thread(()->number1Test.test3()).start();
    }

}
