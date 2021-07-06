package com.automan.siberia.ingestion;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

/**
 * @Author: he.zhou
 * @Date: 2019-04-11
 */
public class Test {
    public static void main(String[] args) {



        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(100,100,0L, MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);

        Collector collector = CollectorFactory.getCollector("hotel.hprice.roomPrice");
        Map map = Maps.newHashMap();
        map.put("sss", "dddd");
        map.put("aaa", 3);
        while (true) {
            collector.track()
                    .setRecordId(UUID.randomUUID().toString())
                    .set("r_type", "大床房")
                    .set("price", 10.2)
                    .set("data", "ddddd")
                    .set("mytest", map)
                    .flush();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
