package com.automan.root.utils.fill.lang;

import com.google.common.collect.Maps;

import java.util.concurrent.ConcurrentMap;

/**
 * @Author: he.zhou
 * @Date: 2019-04-25
 */
public abstract class LazyMap<K,V>{

    private  ConcurrentMap<K, V> map = Maps.newConcurrentMap();

    public V get(K key) {
        V value = map.get(key);
        if (value != null) {
            return value;
        }

        value = load(key);
        V existsValue = (value == null ? null : map.putIfAbsent(key, value));
        return existsValue == null ? value : existsValue;
    }

    protected abstract V load(K key);
}
