package com.automan.siberia.brage.bridgeTest2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author he.zhou
 * @date 2019/12/6
 **/
@Component
public class XiaoMi extends Phone {

    @Autowired
    private Memory8g memory8g;

    @Override
    PhoneMemory getMemory() {
        return memory8g;
    }

    @Override
    String phoneName() {
        return "xiaomi";
    }
}
