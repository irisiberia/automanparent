package com.automan.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2019-07-21
 */
@Component
//@Scope("prototype")
public class LoopTest {

//    @Autowired
//    private AlertRecord alertRecord;

    public LoopTest(AlertRecord alertRecord) {
//        this.alertRecord = alertRecord;
    }
}
