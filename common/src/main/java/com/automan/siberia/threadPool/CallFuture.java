package com.automan.siberia.threadPool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CallFuture {
    protected static ExecutorService threadPool = Executors.newFixedThreadPool(2);


    public static void doFuture() throws ExecutionException, InterruptedException {
        System.out.println("主线程执行");
        FutureTask futureTask = new FutureTask(() -> {
            System.out.println("异步任务执行");
            Thread.sleep(20000);
            return "Stirng";
        });
        threadPool.submit(futureTask);
        if (!futureTask.isCancelled()) {
            System.out.println(futureTask.get().toString());
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallFuture.doFuture();


    }

}
