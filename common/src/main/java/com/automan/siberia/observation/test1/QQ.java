package com.automan.siberia.observation.test1;

import java.util.List;

/**
 * @Author he.zhou
 * @Date 2022-03-13
 */
public class QQ implements Subject {

    private List<Member> members;


    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public void sengMessage(String ss) {
        members.forEach(x -> x.getMessage(ss));
    }
}
