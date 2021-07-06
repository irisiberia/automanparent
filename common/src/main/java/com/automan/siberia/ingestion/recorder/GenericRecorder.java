package com.automan.siberia.ingestion.recorder;


import com.automan.siberia.ingestion.Recorder;

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
