package com.automan.siberia.dataCollect.generic;

import com.automan.siberia.dataCollect.Record;

/**
 * @Author: he.zhou
 * @Date: 2019-04-12
 */
public abstract class GenericRecord<T> implements Record<T> {

    private T data;

    @Override
    public Record set(String key, String value) {
        return setValue(key, value);
    }

    @Override
    public T getData() {
        return recorData();
    }

    @Override
    public void end() {

    }

    public abstract GenericRecord setValue(String key, String value);

    public abstract T recorData();


}
