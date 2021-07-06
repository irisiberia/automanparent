package com.automan.siberia.workrder;

import java.util.LinkedList;

// IM在线的人优先
public class IMOnlineQueueOrder extends QueueOrder {

    @Override
    public LinkedList<Member> getQueue(long queueId) throws Exception {
        LinkedList<Member> members=  getQueueFromSource(23);
        members.removeFirst();
        return members;
    }
}
