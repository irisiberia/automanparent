package com.automan.siberia.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: he.zhou
 * @Date: 2018-10-17
 */
public class ThreadLocalTest {

    private static final ThreadLocal<Integer> value = new ThreadLocal<Integer>();

    public static void set(int i) {
        value.set(i);
        value.remove();
    }

    public static Integer get() {
        return value.get();
    }


    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(new Callable() {
        @Override
        public Object call() throws Exception {
            return null;
        }
    }, 5, TimeUnit.SECONDS);

}
