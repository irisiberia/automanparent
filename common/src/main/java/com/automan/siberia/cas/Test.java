package com.automan.siberia.cas;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: he.zhou
 * @Date: 2019-04-15
 */
public class Test {

    private static AtomicInteger count = new AtomicInteger(0);

    /**
     * Synchronized关键字会让没有得到锁资源的线程进入BLOCKED状态，
     * 而后在争夺到锁资源后恢复为RUNNABLE状态，
     * 这个过程中涉及到操作系统用户模式和内核模式的转换，代价比较高。
     * <p>
     * 自旋锁（spinlock）：是指当一个线程在获取锁的时候，如果锁已经被其它线程获取，那么该线程将循环等待，
     * 然后不断的判断锁是否能够被成功获取，直到获取到锁才会退出循环。
     * 获取锁的线程一直处于活跃状态，但是并没有执行任何有效的任务，使用这种锁会造成busy-waiting。
     *
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //每个线程让count自增100次
                    for (int i = 0; i < 100; i++) {
                        count.incrementAndGet();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);

        List<Integer> list2 = Lists.newArrayList(2, 3, 6);
    }


}
