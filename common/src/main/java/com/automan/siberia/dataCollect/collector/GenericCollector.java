package com.automan.siberia.dataCollect.collector;

import com.automan.siberia.dataCollect.Collector;
import com.automan.siberia.dataCollect.Record;

/**
 * @Author: he.zhou
 * @Date: 2019-04-13
 */
public abstract class GenericCollector implements Collector {

    private String name;


    @Override
    public String getName() {
        return null;
    }

    @Override
    public Record start() {
        return null;
    }
}
