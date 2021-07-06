package com.automan.siberia.observation;

/**
 * @Author: he.zhou
 * @Date: 2019-06-26
 */
public class Test {

    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.subInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");

        server.removeObserver(userZhang);
        server.subInfomation("JAVA是世界上最好用的语言！");

    }
}
