package com.automan.siberia.decorator.test4;

/**
 * @author he.zhou
 * @date 2019/12/7
 **/
public abstract class AddSomething implements IceCream {

    private IceCream iceCream;

    public IceCream getIceCream() {
        return iceCream;
    }

    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }
}
