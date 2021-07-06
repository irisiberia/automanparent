package com.automan.siberia.threadPool;

import java.util.concurrent.*;

public class MyExecutorDemo {
    //执行的任务数量
    private static final int MAX = 10;

    public static void main(String args[]) {
        try {
            fixedThreadPool(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void fixedThreadPool(int coreSize)
            throws InterruptedException, ExecutionException {
        //创建线程池
        ExecutorService exec = Executors.newFixedThreadPool(coreSize);
        for (int i = 0; i < MAX; i++) {
            //提交任务
//            Future<Integer> task = exec.submit(new Callable<Integer>() {
//                @Override
//                public Integer call() throws Exception {
//                    System.out.println("执行线程" + Thread.currentThread().getName());
//                    return fibc(20);
//                }
//            });

            Future<Integer> task1 = exec.submit(() -> {
                System.out.println("执行线程" + Thread.currentThread().getName());
            }, fibc(20));

            //获取执行结果
            System.out.println("第" + i + "次计算，结果为" + task1.get());
        }
        if (!exec.isShutdown()) {
            exec.shutdown();
        }
    }

    //模拟耗时操作，定义一个斐波那契数列
    private static int fibc(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return fibc(num - 1) + fibc(num - 2);
    }

}
