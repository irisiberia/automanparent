package com.automan.root.utils.page;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author: he.zhou
 * @Date: 2019-04-26
 */
public class Limit {
    protected final int page;
    protected final int offset;
    protected final int size;

    @JsonCreator
    protected Limit(@JsonProperty("page") int page, @JsonProperty("offset") int offset, @JsonProperty("size") int size) {
        this.page = page;
        this.offset = offset;
        this.size = size;
    }

    public static Limit createByOffset(int offset, int size) {
        return new Limit(offset / size + 1, offset, size);
    }

    public static Limit createByPage(int page, int size) {
        return new Limit(page, (page - 1) * size, size);
    }

    public int getPage() {
        return this.page;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Limit)) {
            return false;
        } else {
            Limit limit = (Limit)o;
            if (this.page != limit.page) {
                return false;
            } else {
                return this.size == limit.size;
            }
        }
    }

    @Override
    public int hashCode() {
        int result = this.page;
        result = 31 * result + this.size;
        return result;
    }

    @Override
    public String toString() {
        return "Limit{page=" + this.page + ", offset=" + this.offset + ", size=" + this.size + '}';
    }
}
