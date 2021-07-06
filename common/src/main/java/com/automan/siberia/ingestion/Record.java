package com.automan.siberia.ingestion;

import java.util.Iterator;
import java.util.Map;

/**
 * 数据记录
 *
 * @Author: he.zhou
 * @Date: 2019-04-09
 */
public interface Record<T> {

    Record setRecordId(String value);

    Record set(String key, String value);

    Record set(String key, double value);

    Record set(String key, long value);

    Record set(String key, Map<String, Object> value);

    Iterator<Map.Entry> iterator();

    T data();

    void flush();

    Collector getCollector();
}
