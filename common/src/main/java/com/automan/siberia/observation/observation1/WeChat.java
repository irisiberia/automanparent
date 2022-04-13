package com.automan.siberia.observation.observation1;

import com.google.common.collect.Lists;

import java.util.List;

public class WeChat implements Subject {
    public String message;

    public List<Member> memberList = Lists.newArrayList();

    @Override
    public void addMember(Member member) {
        memberList.add(member);
    }

    @Override
    public void deleteMember(Member member) {
        memberList.remove(member);
    }

    @Override
    public void notifyToMember() {
        if (memberList.size() == 0) {
            return;
        }
        memberList.forEach(ar -> {
            ar.receive(message);
        });
    }
}
