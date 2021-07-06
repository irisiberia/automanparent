package com.automan.siberia.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: he.zhou
 * @Date: 2019-06-16
 */
public class TicketLock {

    private static AtomicInteger count = new AtomicInteger();
    /**
     * 服务号
     */
    private static AtomicInteger serviceNum = new AtomicInteger(1);
    /**
     * 排队号
     */
    private static AtomicInteger ticketNum = new AtomicInteger();

    /**
     * lock:获取锁，如果获取成功，返回当前线程的排队号，获取排队号用于释放锁.
     *
     * @return
     */
    public static int lock() {
        int currentTicketNum = ticketNum.incrementAndGet();
        while (currentTicketNum != serviceNum.get()) {
// Do nothing
        }
        return currentTicketNum;
    }

    /**
     * unlock:释放锁，传入当前持有锁的线程的排队号
     *
     * @param ticketnum
     */
    public void unlock(int ticketnum) {
        serviceNum.compareAndSet(ticketnum, ticketnum + 1);
    }

    public static void main(String[] args) {
        System.out.println(lock());
    }
}
