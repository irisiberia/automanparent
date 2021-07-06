package com.automan.siberia.adapterTset1;

import org.springframework.stereotype.Service;

/**
 * @Author: he.zhou
 * @Date: 2018-12-21
 */
@Service
public abstract class WindowAdapter implements Window {

    @Override
    public void open() {
        System.out.println("父类执行：" + "窗户打开");
    }

    @Override
    public void close() {
        System.out.println("父类执行：" + "窗户关闭");
    }

    @Override
    public void activated() {

    }

    @Override
    public void iconified() {
        System.out.println(getWidowName());
    }

    @Override
    public void deiconified() {

    }

    public abstract String getWidowName();
}
