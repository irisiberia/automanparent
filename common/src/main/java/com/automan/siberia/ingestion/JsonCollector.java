package com.automan.siberia.ingestion;


import com.automan.siberia.ingestion.generic.JsonRecord;

import java.util.List;


public class JsonCollector extends GenericCollector {


    public JsonCollector(String name, List<Recorder> recorders) {
        super(name, recorders);
    }

    @Override
    protected Record createRecord() {
        return new JsonRecord(this);
    }
}
