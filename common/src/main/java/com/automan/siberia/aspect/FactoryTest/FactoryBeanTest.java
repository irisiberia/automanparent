package com.automan.siberia.aspect.FactoryTest;

import com.automan.bean.HelloWorld;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2019-01-24
 */
//@Component
public class FactoryBeanTest implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new HelloWorld();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
