package com.automan.siberia.decorator.test4;

import org.springframework.stereotype.Component;

/**
 * @author he.zhou
 * @date 2019/12/7
 **/
@Component
public class BigIceCream implements IceCream {
    @Override
    public String teast() {
        return "大冰淇淋";
    }

    @Override
    public String money() {
        return "10元";
    }
}
