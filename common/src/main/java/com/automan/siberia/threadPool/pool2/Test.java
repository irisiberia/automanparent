package com.automan.siberia.threadPool.pool2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private static AtomicInteger num = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            executorService.execute(() -> {

                System.out.println(Thread.currentThread().getName() + "-->>>>" + num.getAndIncrement());
            });

        }
        executorService.shutdown();
    }
}
