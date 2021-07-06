package com.automan.siberia.pruduceComsumer.LockTest;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

    private static ReentrantLock lock = new ReentrantLock();

    public void getOne() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "获取到锁");
        Thread.sleep(5000);
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
//        Test1 test1 = new Test1();
//        CountDownLatch end = new CountDownLatch(2);
//        new Thread(() -> {
//            try {
//                test1.getOne();
//                end.countDown();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                test1.getOne();
//                end.countDown();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        end.await();
//        System.out.println("执行完毕");

        CountDownLatch end = new CountDownLatch(101);
        ExecutorService executorService = Executors.newFixedThreadPool(101);
        for (int i = 0; i < 101; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getId() + "准备就绪");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                end.countDown();
            });
        }
        end.await();
        System.out.println("全部执行完成");
        executorService.shutdown();



        CyclicBarrier cyclicBarrier = new CyclicBarrier(101, () -> {
            System.out.println("全部执行完成");
        });
        ExecutorService executorService1 = Executors.newFixedThreadPool(101);
        for (int i = 0; i < 101; i++) {
            executorService.submit(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId() + "准备就绪");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    cyclicBarrier.await();
                }
            });
        }
        executorService.shutdown();
    }
}
