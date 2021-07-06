package com.automan.siberia.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: he.zhou
 * @Date: 2019-04-15
 */
public class CasTest2 {

    private static AtomicReference<Thread> cas = new AtomicReference<Thread>();

    public static void lock() {
        Thread current = Thread.currentThread();
        // 利用CAS
        while (!cas.compareAndSet(null, current)) {
            // DO nothing
            System.out.println(Thread.currentThread().getName() + "未获取到锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
    }

    /**
     * 基于cas的自旋锁实现方式
     */
    public static void doLock() {
        Thread current = Thread.currentThread();
        while (true) {
            if (cas.compareAndSet(null, current)) {
                System.out.println(current.getName() + "获取到锁");
                doLock();
                try {
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cas.compareAndSet(current, null);
                break;
            } else {
                System.out.println(current.getName() + "未获取到锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 同步方式的锁
     */
    public synchronized static void doSynchronizedLock() {
        System.out.println(Thread.currentThread().getName() + "获取到锁");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                lock();
//                System.out.println(Thread.currentThread().getName() + "获取到锁");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                unlock();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                lock();
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                unlock();
//            }
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                doLock();
                doLock();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                doLock();
                doLock();
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                doSynchronizedLock();
//                System.out.println(Thread.currentThread().getName()+"执行");
//
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                doSynchronizedLock();
//                System.out.println(Thread.currentThread().getName()+"执行");
//            }
//        }).start();
    }
}
