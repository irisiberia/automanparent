package com.automan.siberia.factorytest.abstractfactory1;

import com.automan.siberia.factorytest.abstractfactory1.factory.BmwFactory;
import com.automan.siberia.factorytest.abstractfactory1.factory.CarFactory;

/**
 * @author he.zhou
 * @date 2019/9/19
 **/
public class Test {
    public static void main(String[] args) {
        CarFactory carFactory = new BmwFactory();
         carFactory.getJiaoChe().name();
        new BmwFactory().getPaoChe().name();

    }


}
