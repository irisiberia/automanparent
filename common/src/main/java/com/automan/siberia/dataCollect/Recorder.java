package com.automan.siberia.dataCollect;

import com.automan.siberia.ingestion.Record;

/**
 * @Author: he.zhou
 * @Date: 2019-04-12
 */
public interface Recorder {
    /**
     * 记录器名称, 便于问题跟踪
     */
    String getName();

    /**
     * 记录器类别, 区分行为
     */
    Type getType();

    /**
     * 记录数据
     */
    void record(Record record);

    public static enum Type {
        log,
        message
    }

}
