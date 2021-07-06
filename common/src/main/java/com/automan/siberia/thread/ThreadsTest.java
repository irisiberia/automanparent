package com.automan.siberia.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * 当一个list很大时，你是否想过进行多线程分组处理？又或者这样一个场景，你想批量处理一个数据库里的数据，
 * 里面数据是几十万，几百万条，你需要每次读1万条出来处理，
 * 而这1万数据如果一条一条顺序处理可想而知所有数据处理完所需要的时间，看下本菜鸟提供的两个分组处理方式
 * <p>
 * <p>
 * 这里所做的是把一个list拼接在一起，不过两种方法各有利弊，第一种方法采用java封装的集合类帮我们实现分组处理，这样的好处首先最明显的就是代码量相对少，
 * 而且我们不需要关心list的大小，缺点也很明显，这样的处理方法是无序的，
 * 不能保证最后的结果顺序拼接，也不能准确确定线程数量，会根据你的CPU自动创建合适数量的线程（不过这个也不能完全算缺点吧）。
 * 第二种方法优点是能保证list拼接的顺序，缺点也很明显，首先代码多了，
 * 另外因为调了list的sublist()，若list截取的结束位置超过了list的大小，方法便会抛异常，其次线程数量也需要自己根据具体场景考虑。
 * ---------------------！
 */
public class ThreadsTest {
    public static String listToStr(List<String> list) {
        StringBuffer str = new StringBuffer();
        Random random = new Random(10);
        Map<Integer, List<String>> group = list.parallelStream().collect(Collectors.groupingBy(e -> random.nextInt(100)));
        group.values().parallelStream().forEach(e -> e.forEach(str::append));
        System.out.println("method1: " + str.toString());
        return str.toString();
    }

    public static String list2Str(List<String> list, final int nThreads) throws Exception {
        if (list == null || list.isEmpty()) {
            return null;
        }

        StringBuffer ret = new StringBuffer();
        int size = list.size();
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        List<Future<String>> futures = new ArrayList<Future<String>>(nThreads);

        for (int i = 0; i < nThreads; i++) {
            final List<String> subList = list.subList(size / nThreads * i, size / nThreads * (i + 1));
            Callable<String> task = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    StringBuffer sb = new StringBuffer();
                    for (String str : subList) {
                        sb.append(str);
                    }
                    return sb.toString();
                }
            };
            futures.add(executorService.submit(task));
        }

        for (Future<String> future : futures) {
            ret.append(future.get());
        }
        executorService.shutdown();
        System.out.println("method2: " + ret.toString());
        return ret.toString();
    }


    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        long ss = System.currentTimeMillis();
        list2Str(list, 4);
        long s1 = System.currentTimeMillis();
        System.out.println(s1 - ss);
        long s2 = System.currentTimeMillis();
        listToStr(list);
        System.out.println(System.currentTimeMillis() - s2);
    }
}
