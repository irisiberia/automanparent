package com.automan.siberia.abstractOrderService1;


import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2018-12-24
 */
@Component
public class ExpireOrderBiz extends AbstractOrderBiz<ExpireOrder> {

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

    @Override
    ExpireOrder toVersionData() {
        ExpireOrder order = new ExpireOrder(1,"ewew");
        order.setId(0);
        order.setType("测试");
        return order;
    }

    @Override
    Class<ExpireOrder> clasz() {
        return ExpireOrder.class;
    }
}
