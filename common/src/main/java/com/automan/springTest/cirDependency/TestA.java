package com.automan.springTest.cirDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author he.zhou
 * @date 2020/1/2
 **/
@Component
public class TestA {

//    private TestB testB;
//
//    public TestA(TestB testB) {
//        this.testB = testB;
//    }

    public void test() {
        System.out.println(" TestA=======");
    }
}
