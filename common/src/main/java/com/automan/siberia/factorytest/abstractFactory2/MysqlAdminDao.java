package com.automan.siberia.factorytest.abstractFactory2;

import org.springframework.stereotype.Component;

/**
 * @author he.zhou
 * @date 2019/9/20
 **/
@Component
public class MysqlAdminDao extends AdminDao {
    @Override
    void save() {
        System.out.println("mysql---->保存admin成功");
    }
}
