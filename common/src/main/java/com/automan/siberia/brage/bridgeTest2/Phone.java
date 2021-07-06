package com.automan.siberia.brage.bridgeTest2;


/**
 * @author he.zhou
 * @date 2019/12/6
 **/
public abstract class Phone {

    public void creatphone() {
        System.out.println(phoneName() + getMemory().size());
    }

    abstract PhoneMemory getMemory();

    abstract String phoneName();

}
