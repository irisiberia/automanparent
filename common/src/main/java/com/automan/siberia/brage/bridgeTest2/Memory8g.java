package com.automan.siberia.brage.bridgeTest2;

import org.springframework.stereotype.Component;

/**
 * @author he.zhou
 * @date 2019/12/6
 **/
@Component
public class Memory8g implements PhoneMemory {
    @Override
    public int size() {
        return 8;
    }
}
