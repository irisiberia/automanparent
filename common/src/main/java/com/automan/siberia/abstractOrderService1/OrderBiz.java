package com.automan.siberia.abstractOrderService1;

/**
 * @Author: he.zhou
 * @Date: 2018-12-24
 */
public interface OrderBiz<T> {

    T generate();

    void update(Class<T> data);

    T queryById();

    T queryByCondition();
}
