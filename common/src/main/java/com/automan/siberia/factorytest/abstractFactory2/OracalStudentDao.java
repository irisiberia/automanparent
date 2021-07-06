package com.automan.siberia.factorytest.abstractFactory2;

import org.springframework.stereotype.Component;

/**
 * @author he.zhou
 * @date 2019/9/20
 **/
@Component
public class OracalStudentDao extends StudentDao {
    @Override
    public void save() {
        System.out.println("Oracal---->Student保存成功");
    }
}
