package com.automan.siberia.proxyTest;

/**
 * @Author: he.zhou
 * @Date: 2019-02-12
 */

public class UserManagerImpl implements UserManager {
    //重写新增用户方法
    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了新增的方法！");
        System.out.println("传入参数为 userName: " + userName + " password: " + password);
//        delUser("ceshi");
    }

    //重写删除用户方法
    @Override
    public void delUser(String userName) {
        System.out.println("调用了删除的方法！");
        System.out.println("传入参数为 userName: " + userName);
    }
}
