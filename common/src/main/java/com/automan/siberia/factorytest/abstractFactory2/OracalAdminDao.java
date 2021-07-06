package com.automan.siberia.factorytest.abstractFactory2;

/**
 * @author he.zhou
 * @date 2019/9/20
 **/
public class OracalAdminDao extends AdminDao {
    @Override
    void save() {
        System.out.println("Oracal---->admin保存成功");
    }
}
