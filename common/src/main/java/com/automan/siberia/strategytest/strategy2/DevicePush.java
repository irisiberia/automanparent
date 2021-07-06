package com.automan.siberia.strategytest.strategy2;

import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2019-04-12
 */
@Component
public class DevicePush extends PushData {
    @Override
    int type() {
        return 2;
    }

    @Override
    String pushData() {
        return "设备推送";
    }
}
