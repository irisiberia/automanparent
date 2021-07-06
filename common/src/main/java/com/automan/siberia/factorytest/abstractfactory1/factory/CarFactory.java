package com.automan.siberia.factorytest.abstractfactory1.factory;

import com.automan.siberia.factorytest.abstractfactory1.jiaoche.JiaoChe;
import com.automan.siberia.factorytest.abstractfactory1.paoche.PaoChe;
import com.automan.siberia.factorytest.abstractfactory1.suv.Suv;

/**
 * @author he.zhou
 * @date 2019/9/19
 **/
public interface CarFactory {
    JiaoChe getJiaoChe();
    Suv getSuv();
    PaoChe getPaoChe();
}
