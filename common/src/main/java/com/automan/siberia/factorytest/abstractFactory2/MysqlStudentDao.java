package com.automan.siberia.factorytest.abstractFactory2;

import org.springframework.stereotype.Component;

/**
 * @author he.zhou
 * @date 2019/9/20
 **/
@Component
public class MysqlStudentDao extends StudentDao {
    @Override
    public void save() {
        System.out.println("mysql---->student保存成功");
    }
}
