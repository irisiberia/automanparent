package com.automan.siberia.proxyTest;

/**
 * @Author: he.zhou
 * @Date: 2019-02-12
 */
public interface UserManager {
    /**
     * 新增用户抽象方法
     */
    void addUser(String userName,String password);

    /**
     * 删除用户抽象方法
     */
    void delUser(String userName);

}