package com.automan.siberia.selfdo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: he.zhou
 * @Date: 2018-11-07
 */
public class FutureTest {
    public static void main(String[] args) {

        System.out.println("====进入主线程执行任务");

        //通过线程池管理多线程
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

//        ExecutorService t=Executors.newScheduledThreadPool(3);
        //线程池提交一个异步任务
        System.out.println("====提交异步任务");

        Future<?> future = threadPool.submit(() -> {
            System.out.println("异步线程开始执行");
            Thread.sleep(10000);
            return new HashMap<String, String>() {{
                this.put("futureKey", "成功获取future异步任务结果");
            }};
        });


        FutureTask  futureTask=new FutureTask(()->{
            return null;
        });



        System.out.println("====提交异步任务之后，立马返回到主线程继续往下执行");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("====此时需要获取上面异步任务的执行结果");

        boolean flag = true;
        while (flag) {
            //异步任务完成并且未被取消，则获取返回的结果
            if (future.isDone() && !future.isCancelled()) {
                HashMap<String, String> futureResult = null;
                try {
                    futureResult = (HashMap<String, String>) future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
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
