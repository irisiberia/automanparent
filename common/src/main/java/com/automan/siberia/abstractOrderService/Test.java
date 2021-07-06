package com.automan.siberia.abstractOrderService;

/**
 * @Author: he.zhou
 * @Date: 2018-12-24
 */
public class Test {
    public static void main(String[] args) {

        ExpireOrder expireOr = new ExpireOrder();
        String order1 = expireOr.generate();
        System.out.println(order1);

        System.out.println("================");
        AbstractOrderBiz checkOr = new CheckOrder();
        String order2 = checkOr.generate();
        System.out.println(order2);


    }
}
