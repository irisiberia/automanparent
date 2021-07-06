package com.automan.siberia.strategytest.strategy2;

import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2019-04-12
 */
@Component
public class IotPush extends PushData {
    @Override
    int type() {
        return 1;
    }

    @Override
    String pushData() {
        return "iot推送数据";
    }
}
