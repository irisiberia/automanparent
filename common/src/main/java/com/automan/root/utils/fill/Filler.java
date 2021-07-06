package com.automan.root.utils.fill;

import java.util.Map;
import java.util.Set;

/**
 * @Author: he.zhou
 * @Date: 2019-04-25
 */
public interface Filler<Fillable, K, V> {

    int DEFAULT_BATCH_SIZE = 1000;

    K getBeanKey(Fillable bean);

    Map<K, V> prepareData(Set<K> keys);

    void fill(Fillable bean, V data);

    /**
     * 加载数据批次大小
     *
     * @return
     */
    default int batchSize() {
        return DEFAULT_BATCH_SIZE;
    }
}
