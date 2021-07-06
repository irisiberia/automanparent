package com.automan.bean;

import com.automan.siberia.abstractOrderService.CheckOrder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
//@Component
public class Red implements ApplicationContextAware, BeanNameAware {

    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String s) {
        System.out.println("当前bean名字:" + s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入ioc：" + applicationContext);
        this.applicationContext = applicationContext;
        CheckOrder checkOrder = (CheckOrder) applicationContext.getBean("checkOrder");
//        checkOrder.generateCheck();
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
