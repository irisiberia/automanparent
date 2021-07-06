package com.automan.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2019-06-25
 */
@Component
public class Student implements BeanNameAware {


    @Override
    public void setBeanName(String name) {

    }
}
