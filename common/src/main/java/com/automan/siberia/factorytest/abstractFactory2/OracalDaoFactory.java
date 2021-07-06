package com.automan.siberia.factorytest.abstractFactory2;

/**
 * @author he.zhou
 * @date 2019/9/20
 **/
public class OracalDaoFactory extends DaoFactory {
    @Override
    AdminDao creatAdminDao() {
        return  new  OracalAdminDao();
    }

    @Override
    StudentDao creatStudentDao() {
        return new OracalStudentDao();
    }
}
