package com.automan.siberia;

import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

/**
 * @Author: he.zho
 * @Date: 2019-07-28
 */
public class Student {
    public static long OUTER_DATE = System.currentTimeMillis();

    static {
        System.out.println("外部类静态块加载时间:" + System.currentTimeMillis());
    }

    public Student() {
        System.out.println("外部类构造时间:" + System.currentTimeMillis());
    }

    static class InnerStaticClass {
        public static long INNER_STATIC_DATE = System.currentTimeMillis();
    }

    class InnerClass {
        public long INNER_DATE = 0;

        public InnerClass() {
            INNER_DATE = System.currentTimeMillis();
        }
    }

    public static void timeElapsed() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void outerStaticMethod() {
        System.out.println("外部类静态方法执行了");
    }

    public static void main(String[] args) {
        timeElapsed();
        System.out.println("打印时间：" + System.currentTimeMillis() + ".....静态内部类加载时间：" + Student.InnerStaticClass.INNER_STATIC_DATE);
        timeElapsed();
        System.out.println("打印时间：" + System.currentTimeMillis() + ".....外部类静态变量加载时间：" + Student.OUTER_DATE);
        timeElapsed();
        System.out.println("打印时间：" + System.currentTimeMillis() + ".....调用外部静态方法：");
        Student.outerStaticMethod();
        timeElapsed();
        Student student1 = new Student();
        System.out.println("打印时间：" + System.currentTimeMillis() + ".....非静态内部类加载时间：" + student1.new InnerClass().INNER_DATE);

        List<String> list = new ArrayList<>();
        list.add(6, "2323");

        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("ew", "ewew");


    }


}


