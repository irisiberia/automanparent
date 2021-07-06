package com.automan.siberia.pruduceComsumer.LockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {

    private int num = 1;
    private int flag = 1;

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    public void one() {
        while (num < 60) {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+ "获取了锁");
            if (flag == 1) {
                for (int i = 1; i <= 3; i++) {
                    System.out.println(Thread.currentThread().getName() + "==" + num);
                    num++;
                }
                flag = 2;
                System.out.println(Thread.currentThread().getName()+"唤醒其他线程");
                c2.signal();
            } else {
                try {
                    System.out.println(Thread.currentThread().getName()+"当前线程阻塞");
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+ "释放了锁");
            lock.unlock();
        }
    }

    public void two() {
        while (num < 60) {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+ "获取了锁");
            if (flag == 2) {
                for (int i = 1; i <= 3; i++) {
                    System.out.println(Thread.currentThread().getName() + "==" + num);
                    num++;
                }
                flag = 1;
                System.out.println(Thread.currentThread().getName()+"唤醒其他线程");
                c1.signal();
            } else {
                try {
                    System.out.println(Thread.currentThread().getName()+"当前线程阻塞");
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+ "释放了锁");
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Test2 test2=new Test2();
        new Thread(()->test2.one()).start();
        new Thread(()->test2.two()).start();
    }
}
