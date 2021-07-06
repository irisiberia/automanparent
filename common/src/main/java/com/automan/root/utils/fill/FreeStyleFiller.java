package com.automan.root.utils.fill;

import java.util.Collection;

/**
 * @Author: he.zhou
 * @Date: 2019-04-25
 */
public interface FreeStyleFiller<Fillable> {

    void multiFill(Collection<Fillable> collection);
}
