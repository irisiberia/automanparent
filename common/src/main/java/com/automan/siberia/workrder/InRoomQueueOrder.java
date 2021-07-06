package com.automan.siberia.workrder;

import java.util.LinkedList;

// 不在面试中的人优先
public class InRoomQueueOrder extends QueueOrder {
    @Override
    public LinkedList<Member> getQueue(long queueId) throws Exception {
        LinkedList<Member> members=  getQueueFromSource(23);
        members.removeFirst();
        return members;
    }
}
