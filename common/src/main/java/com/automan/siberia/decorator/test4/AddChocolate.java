package com.automan.siberia.decorator.test4;

import org.springframework.stereotype.Component;

/**
 * @author he.zhou
 * @date 2019/12/7
 **/
@Component
public class AddChocolate extends AddSomething {

    @Override
    public String teast() {
        return getIceCream().teast() + "添加巧克力";
    }
    @Override
    public String money() {
        return getIceCream().money() + "5元";
    }
}
