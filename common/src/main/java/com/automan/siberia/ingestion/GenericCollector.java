package com.automan.siberia.ingestion;

import java.util.List;
import java.util.UUID;

public abstract class GenericCollector implements Collector {

    protected final String name;
    protected final List<Recorder> recorders;

    protected GenericCollector(String name, List<Recorder> recorders) {
        this.name = name;
        this.recorders = recorders;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Record track() {

        long timestamp = System.currentTimeMillis();
        // TODO: get traceID from CAT
        String requestId = "";
        String logId = UUID.randomUUID().toString();

        return createRecord()
                .set("_req_id", requestId)
                .set("_ts", timestamp)
                .set("_log_id", logId);
    }

    protected abstract Record createRecord();

    public List<Recorder> getRecorders() {
        return recorders;
    }
}
