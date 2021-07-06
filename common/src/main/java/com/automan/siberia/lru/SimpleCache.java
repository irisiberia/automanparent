package com.automan.siberia.lru;

import com.google.common.collect.Lists;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleCache<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_NODE_NUM = 100;

    private int limit;

    public SimpleCache() {
        this(MAX_NODE_NUM);
    }

    public SimpleCache(int limit) {
        super(limit, 0.75f, true);
        this.limit = limit;
    }

    public V save(K key, V val) {
        return put(key, val);
    }

    public V getOne(K key) {
        return get(key);
    }

    public boolean exists(K key) {
        return containsKey(key);
    }

    /**
     * 判断节点数是否超限
     *
     * @param eldest
     * @return 超限返回 true，否则返回 false
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }

    public static void main(String[] args) {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("5", "ewew");
        hashMap.put("1", "ewew");
        hashMap.put("2", "ewew");
        hashMap.put("3", "ewew");
        hashMap.put("4", "ewew");
        hashMap.get("eee");

        hashMap.entrySet().forEach(ar -> {
            System.out.println(ar.getKey());
        });
        System.out.println("==============");

        HashMap<String, String> hashMap1 = new HashMap<>();
        hashMap1.put("5", "ewew");
        hashMap1.put("1", "ewew");
        hashMap1.put("2", "ewew");
        hashMap1.put("3", "ewew");
        hashMap1.put("4", "ewew");

        hashMap1.entrySet().forEach(ar -> {
            System.out.println(ar.getKey());
        });

    }
}
