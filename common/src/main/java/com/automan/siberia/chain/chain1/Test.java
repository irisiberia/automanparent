package com.automan.siberia.chain.chain1;

import com.google.common.collect.Lists;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list= Lists.newArrayList(1,2,3,4);
        list.remove(3);
        System.out.println(list);

    }
}
