package com.automan.siberia.redis;

/**
 * @Author: he.zhou
 * @Date: 2019-04-26
 */
public class Test {
    public static void main(String[] args) {
        new AbstractTemplate<String>() {
            @Override
            public String success() {
                return null;
            }

            @Override
            public String fail() {
                return null;
            }
        }.execute();
    }
}
