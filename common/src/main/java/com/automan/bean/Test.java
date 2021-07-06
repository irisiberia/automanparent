package com.automan.bean;

import com.alibaba.fastjson.JSONObject;
import com.automan.siberia.aspect.FactoryTest.FactoryBeanTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: he.zhou
 * @Date: 2018-12-28
 */
public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorld.class);

        HelloWorld helloWorld = (HelloWorld) context.getBean("Arrange");
        HelloWorld helloWorld2 = (HelloWorld) context.getBean("Arrange");
        System.out.println(JSONObject.toJSONString(helloWorld));
        System.out.println(JSONObject.toJSONString(helloWorld2));
        System.out.println(helloWorld2);

    }


//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FactoryBeanTest.class);
//        Object helloWorld = context.getBean("&factoryBeanTest");
//        Object helloWorld1 = context.getBean("factoryBeanTest");
//        System.out.println(helloWorld);
//        System.out.println(helloWorld1);
//    }


}
