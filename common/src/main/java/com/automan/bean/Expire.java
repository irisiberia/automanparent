package com.automan.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: he.zhou
 * @Date: 2018-12-20
 */
//@Scope("prototype")
@Component
public class Expire implements Serializable {

//    @Autowired
//    private LoopTest loopTest;


    public Expire(LoopTest loopTest) {
//        this.loopTest = loopTest;
    }

    private String orderId;
    private String receiverName;
    private String receiverPhone;
    private List<Person> personList;

    public void sayHello() {
        System.out.println("wwwwwwww");
    }

    public static class Person implements Serializable {
        private String name;
        private String num;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
