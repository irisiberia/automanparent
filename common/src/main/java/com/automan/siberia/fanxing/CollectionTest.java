package com.automan.siberia.fanxing;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author: he.zhou
 * @Date: 2019-04-07
 */
public class CollectionTest<R> {

    private List<R> result;

    public static <R> List<R> getResult(R data) {

        return Lists.newArrayList(data);
    }

    public List<R> getResult() {
        return result;
    }

    public void setResult(List<R> result) {
        this.result = result;
    }
}
