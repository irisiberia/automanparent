package com.automan.siberia.hualala;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author he.zhou
 * @date 2019/11/25
 **/
public class B extends A {
    public void whoAmI() {
        System.out.println(" I am b");
    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        // 创建n个1M大小的数组，耗尽内存


        for (int i = 0; i < 1000000; i++) {

            UUID.randomUUID().toString().intern();


        }
    }
}
