package com.automan.siberia.observation;

import com.automan.root.utils.Safes;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 被观察者，也就是微信公众号服务
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 *
 * @Author: he.zhou
 * @Date: 2019-06-26
 */
public class WechatServer implements Observerable {

    /**
     * 注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
     */
    private List<Observer> list = Lists.newArrayList();

    private String message;

    public void subInfomation(String message) {
        this.message = message;
        System.out.println("微信服务更新消息： " + message);
        //消息更新，通知所有观察者
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObserver() {
        Safes.of(list).forEach(ar -> {
            ar.update(message);
        });
    }
}
