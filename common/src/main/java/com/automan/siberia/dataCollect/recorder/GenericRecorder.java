package com.automan.siberia.dataCollect.recorder;


import com.automan.siberia.dataCollect.Recorder;
import com.automan.siberia.ingestion.Record;

/**
 * @Author: he.zhou
 * @Date: 2019-04-13
 */
public abstract class GenericRecorder implements Recorder {

    protected final String name;

    protected final Type type;

    public GenericRecorder(String name, Type type) {
        this.name = name;
        this.type = type;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

}
