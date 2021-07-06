package com.automan.bean;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: he.zhou
 * @Date: 2018-11-08
 */
//@Scope(value = "")
//@Component
public class HelloWorld implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    private String name;

    public HelloWorld() {
//        System.out.println("对象构造.........");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println(name + "hdshdshgdsghdks");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware 测试====" + name);
    }

    public void test() {
        String ss="ssss";
        System.out.println("Dsdsds");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println("BeanFactoryAware==="+JSONObject.toJSON(beanFactory).toString());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

//    @PostConstruct
//    public void init() {
//        System.out.println("postConstruct" + "初始化方法");
//        this.name = "我是测试";
//    }
}
