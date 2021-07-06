package com.automan.siberia.workrder.order1;

import com.automan.siberia.workrder.Member;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.LinkedList;

/**
 * @author he.zhou
 * @date 2019/9/23
 **/
@Component
public class QueueRoom extends QueueDecorate {

    @Resource
    private DelayQueue delayQueue;

    @PostConstruct
    private void init() {
        setQueue(delayQueue);
    }

    @Override
    public LinkedList<Member> getQueue(long queueId) throws Exception {
        LinkedList<Member> linkedList = queue.getQueue(23);
        linkedList.removeFirst();
        return linkedList;
    }
}
