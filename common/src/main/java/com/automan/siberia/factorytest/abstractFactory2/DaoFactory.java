package com.automan.siberia.factorytest.abstractFactory2;

/**
 * @author he.zhou
 * @date 2019/9/19
 **/
public abstract class DaoFactory {

    abstract AdminDao creatAdminDao();

    abstract StudentDao creatStudentDao();

}
