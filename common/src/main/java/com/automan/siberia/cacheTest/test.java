package com.automan.siberia.cacheTest;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @Author: he.zhou
 * @Date: 2019-01-17
 */
public class test {


    private static final Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();


    public static Map<String, String> buildMap(String str) {
        Map<String, String> map = Maps.newHashMap();
        map.put("22", "33");
        map.put("44", "55");
        cache.putAll(map);
        System.out.println("========执行buildMap====" + str);
        return map;
    }


    public static void main(String[] args) {
        try {
            System.out.println(cache.get("22", () -> buildMap("1").get("22")));

            System.out.println(cache.get("22", () -> buildMap("2").get("22")));
            System.out.println(cache.get("44", () -> buildMap("3").get("44")));

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
