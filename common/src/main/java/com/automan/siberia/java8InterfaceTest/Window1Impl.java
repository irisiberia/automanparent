package com.automan.siberia.java8InterfaceTest;

import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2018-12-23
 */
@Component
public class Window1Impl implements Window {
    @Override
    public void activated() {
        System.out.println("Ssssss");
    }

    @Override
    public void iconified() {

    }

    @Override
    public void deiconified() {

    }

    @Override
    public Window set(String key) {
        return null;
    }

    public void  sin(){
        System.out.println("sss");
    }
}
