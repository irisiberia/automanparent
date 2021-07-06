package com.automan.siberia.factorytest.abstractFactory2;

import org.springframework.stereotype.Component;

/**
 * @author he.zhou
 * @date 2019/9/20
 **/
@Component
public class MysqlDaoFactory extends DaoFactory {

    @Override
    AdminDao creatAdminDao() {
        return new MysqlAdminDao();
    }

    @Override
    StudentDao creatStudentDao() {
        return new MysqlStudentDao();
    }
}
