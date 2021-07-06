package com.automan.siberia.adapterTset1;

import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2018-12-21
 */
@Component
public class WindowImpl extends WindowAdapter implements MywindowBiz {

    @Override
    public void open() {
        System.out.println("子类执行："+"窗口打开。");
    }

    //会覆写父类的方法
    @Override
    public void close() {
        System.out.println("子类执行"+"窗口关闭。");
    }

    @Override
    public String myTest() {
        return "myTest:哈哈哈";
    }

    @Override
    public String getWidowName() {
        return "我是窗户一";
    }
}
