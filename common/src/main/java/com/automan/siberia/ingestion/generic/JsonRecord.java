package com.automan.siberia.ingestion.generic;


import com.alibaba.fastjson.JSONObject;
import com.automan.siberia.ingestion.JsonCollector;
import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;


public class JsonRecord extends GenericRecord<String> {


    private final Map data = Maps.newHashMap();

    public JsonRecord(JsonCollector collector) {
        super(collector);
    }

    @Override
    public GenericRecord set(String key, Object value) {
        data.put(key, value);
        return this;
    }

    @Override
    protected GenericRecord setMap(String key, Map<String, Object> value) {
        data.put(key, value);
        return this;
    }

    @Override
    protected String encode() {
        return JSONObject.toJSONString(data);
    }

    @Override
    public Iterator<Map.Entry> iterator() {
        return data.entrySet().iterator();
    }
}
