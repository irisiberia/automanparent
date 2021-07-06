package com.automan.siberia.pruduceComsumer.LockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程
 * 一个打印5个数
 * 一个打印10个数
 * 一个打印3个数
 * 交替打印
 */
public class ConditionTset {
    private int num = 1;
    private int count = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public void print5() {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "===" + count);
                count++;
            }
            num = 2;
            condition2.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }

            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "===" + count);
                count++;
            }
            num = 3;
            condition3.signal();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void print3() {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }

            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "===" + count);
                count++;
            }
            num = 1;
            condition1.signal();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionTset conditionTset = new ConditionTset();
        new Thread(conditionTset::print5).start();
        new Thread(conditionTset::print10).start();
        new Thread(conditionTset::print3).start();
    }

}
