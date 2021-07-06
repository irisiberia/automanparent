package com.automan.siberia.dataCollect;

/**
 * @Author: he.zhou
 * @Date: 2019-04-12
 */
public interface Record<T> {

    /**
     * 设值
     *
     * @param key
     * @param value
     * @return
     */
    Record set(String key, String value);

    /**
     * 最终数据
     *
     * @return
     */
    T getData();

    /**
     * 结束
     */
    void end();

}
