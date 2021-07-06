package com.automan.siberia.observation;

/**
 * 抽象观察者
 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 *
 *
 *观察者设计模式也称发布订阅模式
 * 在对象之间定义一个一对多的依赖，当一个对象状态改变的时候
 * 所有依赖的对象都会自动接收通知
 *
 *
 * @Author: he.zhou
 * @Date: 2019-06-26
 */
public interface Observer {
    void update(String message);
}
