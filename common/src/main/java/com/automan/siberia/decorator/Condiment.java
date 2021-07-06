package com.automan.siberia.decorator;

/**
 * 继承自Food，使装饰者与组件拥有共同的超类
 *
 * @Author: he.zhou
 * @Date: 2019-01-25
 */
public abstract class Condiment extends Food {
    public abstract String getDesc();
}
