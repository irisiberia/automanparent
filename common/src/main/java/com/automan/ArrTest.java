package com.automan;

import com.google.common.collect.Lists;

import java.util.List;

public class ArrTest {

    private static List<Integer> arr = Lists.newArrayList();


    public void add(int i) {
        while (true) {
            synchronized (this) {
                if (arr.size() <= 10) {
                    arr.add(i);
                    System.out.println(Thread.currentThread().getName() + "==" + "新增数据===" + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

    }


    public void jian() {
        while (true) {
            synchronized (this) {
                if (arr.size() > 0) {
                    System.out.println(Thread.currentThread().getName() + "==消费数据===" + arr.get(0));
                    arr.remove(0);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        ArrTest arrTest = new ArrTest();
        new Thread(() -> {
            arrTest.add(3);
        }).start();
        new Thread(arrTest::jian).start();
    }
}
