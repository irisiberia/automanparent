package com.automan.siberia.dataCollect.recorder;

import com.automan.siberia.ingestion.Record;

/**
 * @Author: he.zhou
 * @Date: 2019-04-13
 */
public class LogRecorder extends GenericRecorder {


    /**
     * 继承默认使用父类的无参的构造方法
     * 如果父类没有无参的构造方法，子类必须使用父类有参构造初始化
     *
     * @param name
     * @param type
     */
    public LogRecorder(String name, Type type) {
        super(name, type);
    }

    @Override
    public void record(Record record) {

    }
}
