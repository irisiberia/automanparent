package com.automan.siberia.ingestion.generic;


import com.automan.siberia.ingestion.GenericCollector;
import com.automan.siberia.ingestion.Record;
import com.automan.siberia.ingestion.Recorder;

import java.util.Map;

public abstract class GenericRecord<T> implements Record<T> {

    private final static String RECORD_ID = "RecordId";

    protected final GenericCollector collector;

    protected T encoded;

    public GenericRecord(GenericCollector collector) {
        this.collector = collector;
    }

    @Override
    public Record set(String key, String value) {
        return this.set(key, (Object) value);
    }

    @Override
    public Record set(String key, double value) {
        return this.set(key, (Object) value);
    }

    @Override
    public Record set(String key, long value) {
        return this.set(key, (Object) value);
    }

    @Override
    public Record set(String key, Map<String, Object> value) {
        return this.setMap(key, value);
    }

    @Override
    public Record setRecordId(String value) {
        return this.set(RECORD_ID, value);
    }


    protected abstract GenericRecord set(String key, Object value);

    protected abstract GenericRecord setMap(String key, Map<String, Object> value);

    protected abstract T encode();

    @Override
    public T data() {
        return encoded == null ? encoded = encode() : encoded;
    }

    @Override
    public void flush() {
        for (Recorder recorder : collector.getRecorders()) {
            try {
                recorder.record(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public GenericCollector getCollector() {
        return collector;
    }
}
