package com.automan.siberia.mianshi2021;

import org.aspectj.weaver.ast.Var;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author he.zhou
 * @Date 2021-11-01
 */
public class Number2Test {
    public static int i = 1;
    public static int flag = 1;
    public static final ReentrantLock lock = new ReentrantLock();
    public static final Condition con1 = lock.newCondition();
    public static final Condition con2 = lock.newCondition();
    public static final Condition con3 = lock.newCondition();

    public void test1() {
        while (i < 100) {
            lock.lock();
            if (flag == 1) {
                System.out.println(Thread.currentThread().getName() + "==-=====");
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
        while (i < 100) {
            lock.lock();
            if (flag == 2) {
                System.out.println(Thread.currentThread().getName() + "==-=====");
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
        while (i < 100) {
            lock.lock();
            if (flag == 3) {
                System.out.println(Thread.currentThread().getName() + "==-=====");
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
        Number2Test number2Test = new Number2Test();
        new Thread(()->number2Test.test1()).start();
        new Thread(()->number2Test.test2()).start();
        new Thread(()->number2Test.test3()).start();
    }


}
