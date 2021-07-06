package com.automan;

import com.alibaba.fastjson.JSONObject;
import com.automan.bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorld.class);

        String s = ((ConfigurableApplicationContext) context).getBeanFactory().resolveEmbeddedValue("${environment}");
        System.out.println(s);

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld");
        System.out.println(JSONObject.toJSONString(helloWorld));
        System.out.println(JSONObject.toJSONString(helloWorld2));
        System.out.println(helloWorld2);

    }
}
