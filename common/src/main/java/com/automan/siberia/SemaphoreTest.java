package com.automan.siberia;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(5, true);


    public void doProcess(int i) {
        try {
            semaphore.acquire();
            System.out.println("doProcess=====start" + i);
            Thread.sleep(5000);
            System.out.println("doProcess=====finish" + i);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> semaphoreTest.doProcess(finalI)).start();
        }


    }

}
