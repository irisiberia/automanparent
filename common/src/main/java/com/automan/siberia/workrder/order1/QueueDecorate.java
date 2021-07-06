package com.automan.siberia.workrder.order1;

/**
 * @author he.zhou
 * @date 2019/9/23
 **/
public abstract class QueueDecorate extends Queue {

    protected Queue queue;

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }
}
