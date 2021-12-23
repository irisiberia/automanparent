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
            if (flag == 2) {
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

    public void test4() {
        while (i <= 100) {
            synchronized (this) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "===" + i);
                    i++;
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

    public void test5() {
        while (i <= 100) {
            synchronized (this) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "===" + i);
                    i++;
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
        Number1Test number1Test = new Number1Test();
        new Thread(number1Test::test4).start();
        new Thread(number1Test::test5).start();
//      new Thread(() -> number1Test.test3()).start();
    }

    /**
     * synchronized 是基于jvm实现的，通过java 对象头锁定和monitor对象实现的
     * 对象在内存中主要分为三个部分：
     * 1.对象头---->markWord  指向类的指针   数组长度
     * 2.实例数据
     * 3.对齐填充字节
     */
}
