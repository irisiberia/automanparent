package com.automan.springTest.cirDependency;

import org.springframework.stereotype.Component;

/**
 * @author he.zhou
 * @date 2020/1/2
 **/

public class TestB {

    private TestA testA;

    private int anInt;

    public TestB(int anInt) {
        this.anInt = anInt;
    }

    public Integer getInt(){
        return anInt;
    }
}
