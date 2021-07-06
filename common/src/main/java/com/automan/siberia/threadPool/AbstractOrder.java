package com.automan.siberia.threadPool;

import java.util.logging.Logger;

/**
 * @Author: he.zhou
 * @Date: 2018-10-18
 */
public abstract class AbstractOrder<T> implements OrderStorage<T> {

    protected abstract String getAppId();

    protected abstract String[] getSectionNameArray();

    protected abstract Logger getLogger();

    @Override
    public T generate(T data, String s) {
        return null;
    }

    @Override
    public T update(T data, String opLog) {
        return null;
    }

    @Override
    public T queryById(long orderId) {
        return null;
    }
}
