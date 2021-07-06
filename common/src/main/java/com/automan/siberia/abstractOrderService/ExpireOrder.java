package com.automan.siberia.abstractOrderService;


import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2018-12-24
 */
@Component
public class ExpireOrder extends AbstractOrderBiz {

    @Override
    String getOrdrType() {
        return "Expire";
    }

    @Override
    void generateCheck() {
        System.out.println("效期单生单前检查：成功");
    }

    @Override
    void endOrder() {
        System.out.println("效期单生单结束");
    }

    @Override
    int setTableId() {
        return 23;
    }
}
