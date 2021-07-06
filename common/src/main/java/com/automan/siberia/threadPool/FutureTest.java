package com.automan.siberia.threadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.concurrent.*;

public class FutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * 可以使用new Callable（），也能使用(()->{});
         *
         * executor.submit(new Callable()) :submit里面是Callable的子类
         *
         */
        System.out.println("====进入主线程执行任务");

        //通过线程池管理多线程
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        ExecutorService threadPool1 = Executors.newSingleThreadExecutor();
        ExecutorService threadPool2 = Executors.newScheduledThreadPool(2);
        ExecutorService threadPool3= Executors.newCachedThreadPool();
        //阿里巴巴  手动创建线程池
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(100, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(12), namedThreadFactory);

//        ExecutorService t=Executors.newScheduledThreadPool(3);
        //线程池提交一个异步任务
        System.out.println("====提交异步任务");
        //FutureTask是Future的一个实现类，创建需要new
        /**
         * 第一种写法
         */
        FutureTask<HashMap<String, String>> future1 = new FutureTask<HashMap<String, String>>(new Callable<HashMap<String, String>>() {
            @Override
            public HashMap<String, String> call() throws Exception {
                System.out.println("异步任务开始执行....");
                Thread.sleep(10000);
                System.out.println("异步任务执行完毕，返回执行结果!!!!");

                return new HashMap<String, String>() {
                    {
                        this.put("futureKey", "成功获取future异步任务结果");
                    }
                };
            }

        });


        FutureTask<HashMap<String, String>> future2 = new FutureTask<HashMap<String, String>>(() -> {
            System.out.println("异步任务开始执行....");
            Thread.sleep(10000);
            System.out.println("异步任务执行完毕，返回执行结果!!!!");
            return new HashMap<String, String>() {
                {
                    this.put("futureKey", "成功获取future异步任务结果");
                }
            };
        });

        //两种启动方式
        threadPool.submit(future2);
//        new Thread(future1).start();


        /**
         *    第二种写法
         *    Future是一个接口，创建方式： Future<HashMap<String,String>> future == threadPool.submit(()->{});
         */
        Future<HashMap<String, String>> future3 = threadPool.submit(new Callable<HashMap<String, String>>() {

            @Override
            public HashMap<String, String> call() throws Exception {

                System.out.println("异步任务开始执行....");
                Thread.sleep(10000);
                System.out.println("异步任务执行完毕，返回执行结果!!!!");

                return new HashMap<String, String>() {
                    {
                        this.put("futureKey", "成功获取future异步任务结果");
                    }
                };
            }

        });

        /**
         *第三种写法,同第二种方法
         */
        Future<?> future = threadPool.submit(() -> {
            System.out.println("异步任务开始执行....");
            System.out.println("异步任务执行完毕，返回执行结果!!!!");
            Thread.sleep(10000);
            return new HashMap<String, String>() {
                {
                    this.put("futureKey", "成功获取future异步任务结果");
                }
            };
        });


        System.out.println("====提交异步任务之后，立马返回到主线程继续往下执行");
        Thread.sleep(2000);

        System.out.println("====此时需要获取上面异步任务的执行结果");

        boolean flag = true;
        while (flag) {
            //异步任务完成并且未被取消，则获取返回的结果
            if (future2.isDone() && !future2.isCancelled()) {
                HashMap<String, String> futureResult = (HashMap<String, String>) future2.get();
                System.out.println("====异步任务返回的结果是：" + futureResult.get("futureKey"));
                flag = false;
            }
        }

        //关闭线程池
        if (!threadPool.isShutdown()) {
            threadPool.shutdown();
        }
    }
}
