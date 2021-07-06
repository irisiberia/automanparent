package com.automan.siberia.thread.deadlock;

/**
 * @Author: he.zhou
 * @Date: 2019-07-12
 */
public class Test {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        LockDemoA demoA=  new LockDemoA(lockA, lockB);
        LockDemoA demoB=  new LockDemoA(lockB, lockA);


        new Thread(demoA::run,"ewewewewe").start();
        new Thread(demoB::run,"ThreadBBBBB").start();
    }
}
