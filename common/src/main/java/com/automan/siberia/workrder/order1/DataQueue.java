package com.automan.siberia.workrder.order1;

import com.automan.siberia.workrder.Member;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

/**
 * @author he.zhou
 * @date 2019/9/23
 **/
@Component
public class DataQueue extends Queue {

    @Override
    public LinkedList<Member> getQueue(long queueId) throws Exception {
        Member member = new Member();
        member.setAnInt(333);

        Member member1 = new Member();
        member1.setAnInt(444);

        Member member2 = new Member();
        member2.setAnInt(555);

        Member member3 = new Member();
        member3.setAnInt(666);

        Member member4 = new Member();
        member4.setAnInt(666);

        LinkedList<Member> list = Lists.newLinkedList();
        list.add(member);
        list.add(member1);
        list.add(member2);
        list.add(member3);
        list.add(member4);
        return list;
    }
}
