package com.automan.siberia.factorytest.abstractfactory1.factory;

import com.automan.siberia.factorytest.abstractfactory1.jiaoche.AudiJiaoChe;
import com.automan.siberia.factorytest.abstractfactory1.jiaoche.JiaoChe;
import com.automan.siberia.factorytest.abstractfactory1.paoche.AudiPaoche;
import com.automan.siberia.factorytest.abstractfactory1.paoche.PaoChe;
import com.automan.siberia.factorytest.abstractfactory1.suv.AudiSuv;
import com.automan.siberia.factorytest.abstractfactory1.suv.Suv;

/**
 * @author he.zhou
 * @date 2019/9/19
 **/
public class AudiFactory implements CarFactory {
    @Override
    public JiaoChe getJiaoChe() {
        return new AudiJiaoChe();
    }

    @Override
    public Suv getSuv() {
        return new AudiSuv();
    }

    @Override
    public PaoChe getPaoChe() {
        return new AudiPaoche();
    }
}
