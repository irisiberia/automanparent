package com.automan.siberia.pruduceComsumer.LockTest;

/**
 * 两个线程交替打印
 * 每次递增3
 */
public class Test {
    private static int end = 60;
    private static int start = 1;
    ThreadLocal<Boolean> has = ThreadLocal.withInitial(() -> false);


    public void one() throws InterruptedException {
        while (true) {
            if (start > end) {
                break;
            }
            synchronized (this) {
                if (!has.get()) {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(start);
                    System.out.println(start + 1);
                    System.out.println(start + 2);
                    start = start + 3;
                    has.set(true);
                    notify();
                } else {
                    has.set(false);
                    wait();
                }
            }
        }
    }


    public static void main(String[] args) {
        Test test = new Test();
        new Thread(() -> {
            try {
                test.one();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                test.one();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
