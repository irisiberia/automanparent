package com.automan.siberia.pruduceComsumer.numberThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author he.zhou
 * @Date 2022-03-13
 */
public class Number5 {
    private static ReentrantLock lock = new ReentrantLock();
    private static int num = 0;
    private static int flag = 1;

    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();


    private void test1() {
        while (num <= 100) {
            lock.lock();
            if (flag == 1) {
                System.out.println(Thread.currentThread().getName() + "===" + num);
                num++;
                flag = 2;
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


    private void test2() {
        while (num <= 100) {
            lock.lock();
            if (flag == 2) {
                System.out.println(Thread.currentThread().getName() + "===" + num);
                num++;
                flag = 3;
                condition3.signal();
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

    private void test3() {
        while (num <= 100) {
            lock.lock();
            if (flag == 3) {
                System.out.println(Thread.currentThread().getName() + "===" + num);
                num++;
                flag=1;
                condition1.signal();
            } else {
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();

        }
    }

    public static void main(String[] args) {
        Number5 number5=new Number5();
        new Thread(number5::test1).start();
        new Thread(number5::test2).start();
        new Thread(number5::test3).start();
    }
}
