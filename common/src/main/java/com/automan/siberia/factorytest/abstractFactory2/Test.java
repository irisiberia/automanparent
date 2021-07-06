package com.automan.siberia.factorytest.abstractFactory2;

/**
 * @author he.zhou
 * @date 2019/9/20
 **/
public class Test {
    public static void main(String[] args) {
        new MysqlDaoFactory().creatAdminDao().save();
    }
}
