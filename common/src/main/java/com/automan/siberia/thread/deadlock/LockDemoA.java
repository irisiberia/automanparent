package com.automan.siberia.thread.deadlock;

/**
 * @Author: he.zhou
 * @Date: 2019-07-12
 */
public class LockDemoA  {

    private String lockA;

    private String lockB;


    public LockDemoA(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }


    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "获取到锁" + lockA + "=====" + " 要获取锁" + lockB);

            try {
                Thread.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + lockB);
            }
        }
    }
}


