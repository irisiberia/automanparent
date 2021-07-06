package com.automan.siberia.workrder.order1;

import com.automan.siberia.workrder.Member;

import java.util.LinkedList;

/**
 * @author he.zhou
 * @date 2019/9/23
 **/
public abstract class Queue {
    public abstract LinkedList<Member> getQueue(long queueId) throws Exception;
}
