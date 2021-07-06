package com.automan.siberia.functionTest;

import java.util.List;

@FunctionalInterface
public interface SimpleStartLimitQueryTemplate<T> {
    List<T> query(int start, int limit);
}
