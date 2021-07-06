package com.automan.siberia.adapterTest;

/**
 * @Author: he.zhou
 * @Date: 2018-12-13
 */
public class Service extends Wapper {
    @Override
    public void Mysql() {
        System.out.println("服务开始");
    }

    @Override
    public void Oracle() {
        System.out.println("服务开始");
    }

    @Override
    public void NET() {
        System.out.println("都要执行222");
    }
}
