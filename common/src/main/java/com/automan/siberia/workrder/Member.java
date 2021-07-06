package com.automan.siberia.workrder;

/**
 * @author he.zhou
 * @date 2019/9/18
 **/
public class Member {

    private int anInt;

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public String toString() {
        return "Member{" +
                "anInt=" + anInt +
                '}';
    }
}
