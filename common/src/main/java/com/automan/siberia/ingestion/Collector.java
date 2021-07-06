package com.automan.siberia.ingestion;

/**
 * @Author: he.zhou
 * @Date: 2019-04-09
 */
public interface Collector {

    String getName();

    Record track();

}
