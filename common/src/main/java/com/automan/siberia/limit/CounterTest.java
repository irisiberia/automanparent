package com.automan.siberia.limit;

/**
 * 限流算法===计数器算法
 * @Author he.zhou
 * @Date 2021-03-15
 */
public class CounterTest {
    public long timeStamp = getNowTime();
    public volatile int reqCount = 0;
    public final int limit = 4; // 时间窗口内最大请求数
    public final long interval = 5000; // 时间窗口ms

    public boolean grant() {
        long now = getNowTime();
        if (now < timeStamp + interval) {
            // 在时间窗口内
            reqCount++;
            // 判断当前时间窗口内是否超过最大请求控制数
            return reqCount <= limit;
        } else {
            timeStamp = now;
            // 超时后重置
            reqCount = 1;
            return true;
        }
    }

    public long getNowTime() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        CounterTest counterTest = new CounterTest();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> System.out.println(counterTest.grant())).start();
        }

        CounterTest counterTest1 = new CounterTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println("===" + counterTest1.grant())).start();
        }
    }
}
