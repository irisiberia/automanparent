package com.automan.siberia.java8InterfaceTest;

/**
 * @Author: he.zhou
 * @Date: 2018-12-23
 */
public interface Window {

    default void open() {
        System.out.println("接口：窗户打开");
    }

    default void close() {
        System.out.println("接口：窗户关闭");
    }

    void activated();    // 窗口活动

    void iconified();    // 窗口最小化

    void deiconified();// 窗口恢复大小

    Window set (String key);
}
