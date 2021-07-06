package com.automan.siberia.threadPool;

/**
 * @Author: he.zhou
 * @Date: 2018-10-18
 */
public interface OrderStorage<T> {
    T generate(T data, String s);

    T update(T data, String opLog);

    T queryById(long orderId);

}
