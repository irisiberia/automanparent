package com.automan.siberia.observation.observation1;

import com.google.common.collect.Lists;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.List;

/**
 * @Author he.zhou
 * @Date 2022-01-23
 */
public class QQ implements Subject {

    private List<Member> members = Lists.newArrayList();

    @Override
    public void addMember(Member member) {

    }

    @Override
    public void deleteMember(Member member) {

    }

    @Override
    public void notifyToMember() {

    }
}
