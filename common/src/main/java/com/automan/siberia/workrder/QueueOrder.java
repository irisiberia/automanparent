package com.automan.siberia.workrder;

import java.util.LinkedList;

/**
 * 使用装饰者模式给队列排序 多种排序规则同时生效
 */
public abstract class QueueOrder {

    private QueueOrder source;

    public void setSource(QueueOrder source) {
        this.source = source;
    };

    protected LinkedList<Member> getQueueFromSource(long queueId) throws Exception {
        return source.getQueue(queueId);
    }

    public abstract LinkedList<Member> getQueue(long queueId) throws Exception;

}
