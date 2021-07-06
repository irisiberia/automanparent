package com.automan.siberia.workrder;

import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class DelayEnterRoomQueueOrder extends QueueOrder {

    @Override
    public LinkedList<Member> getQueue(long queueId) throws Exception {
        LinkedList<Member> members=  getQueueFromSource(23);
        members.removeFirst();
        return members;
    }
}
