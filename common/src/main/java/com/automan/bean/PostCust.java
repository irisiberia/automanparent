package com.automan.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author he.zhou
 * @date 2019/12/20
 **/
@Component
public class PostCust {

    private String code;

    public PostCust() {
        System.out.println("PostCust  构造方法执行");
    }

    @PostConstruct
    private void init(){
        System.out.println("PostConstruct zhixing");
    }

    public  void test(){
        System.out.println("Dddd");
    }
}
