package com.automan.siberia.pruduceComsumer.LockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {
    private int i = 1;
    private int num = 1;
    private static final ReentrantLock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();

    public void test1() {
        while (num < 60) {
            lock.lock();
            if (i == 1) {
                System.out.println(Thread.currentThread().getName() + "ABC");
                i = 2;
                num++;
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

    public void test2() {
        while (num < 60) {
            lock.lock();
            if (i == 2) {
                System.out.println(Thread.currentThread().getName() + "ABC");
                i = 3;
                num++;
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

    public void test3() {
        while (num < 60) {
            lock.lock();
            if (i == 3) {
                System.out.println(Thread.currentThread().getName() + "ABC");
                i = 1;
                num++;
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
        Test3 test3 = new Test3();
        new Thread(test3::test1).start();
        new Thread(test3::test2).start();
        new Thread(test3::test3).start();
    }
}
