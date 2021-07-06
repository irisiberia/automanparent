package com.automan.root.utils.template;

import com.automan.root.utils.page.PageRequest;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: he.zhou
 * @Date: 2019-04-26
 */
public abstract class BatchPagedLoadTemplate<D, Q extends PageRequest> {

    private Q query;

    public BatchPagedLoadTemplate(Q query) {
        this.query = query;
    }

    public Iterable<D> execute() {
        return () -> new Iterator<D>() {
            Iterator<D> iterator;

            @Override
            public boolean hasNext() {
                if ((iterator == null || !iterator.hasNext())) {
                    query.setPage(new PageRequest.Page(query.getPage().getPageSize(), query.getPage().getPageNo() + 1));
                    List<D> data = queryData(query);
                    if (CollectionUtils.isEmpty(data)) {
                        return false;
                    }
                    iterator = data.iterator();
                }
                return iterator.hasNext();
            }
            @Override
            public D next() {
                return iterator.next();
            }
        };
    }

    protected abstract List<D> queryData(Q query);
}
