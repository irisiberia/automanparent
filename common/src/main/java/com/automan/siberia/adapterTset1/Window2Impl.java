package com.automan.siberia.adapterTset1;

import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2018-12-21
 */
@Component
public class Window2Impl extends WindowAdapter {

    @Override
    public void open() {
        System.out.println("子类执行：窗口打开。");
    }

    @Override
    public String getWidowName() {
        return "我是窗户二";
    }

}
