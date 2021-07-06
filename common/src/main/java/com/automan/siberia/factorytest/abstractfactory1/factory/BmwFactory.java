package com.automan.siberia.factorytest.abstractfactory1.factory;

import com.automan.siberia.factorytest.abstractfactory1.jiaoche.BmwJiaoChe;
import com.automan.siberia.factorytest.abstractfactory1.jiaoche.JiaoChe;
import com.automan.siberia.factorytest.abstractfactory1.paoche.BmwPaoChe;
import com.automan.siberia.factorytest.abstractfactory1.paoche.PaoChe;
import com.automan.siberia.factorytest.abstractfactory1.suv.Suv;

/**
 * @author he.zhou
 * @date 2019/9/19
 **/
public class BmwFactory implements CarFactory {
    @Override
    public JiaoChe getJiaoChe() {
        return new BmwJiaoChe();
    }

    @Override
    public Suv getSuv() {
        return null;
    }
    @Override
    public PaoChe getPaoChe() {
        return new BmwPaoChe();
    }
}
