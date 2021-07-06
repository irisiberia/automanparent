package com.automan.siberia.adapterTest;

/**
 * @Author: he.zhou
 * @Date: 2018-12-13
 */
public abstract class Wapper implements Port{
    @Override
    public void SSH() {

    }

    @Override
    public void NET() {
        System.out.println("都要执行");
    }

    @Override
    public void Tomcat() {

    }

    @Override
    public void Mysql() {

    }

    @Override
    public void Oracle() {

    }

    @Override
    public void FTP() {

    }
}
