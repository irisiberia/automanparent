package com.automan.siberia.abstractOrderService1;


import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2018-12-24
 */
@Component
public class CheckOrderBiz extends AbstractOrderBiz<CheckOrder> {

    @Override
    public String getOrdrType() {
        return "Check";
    }

    @Override
    public void generateCheck() {
        System.out.println("盘点单生单前检查：成功");
    }

    @Override
    public void endOrder() {
        System.out.println("盘点单生单成功");
    }

    @Override
    int setTableId() {
        return 12;
    }

    @Override
    CheckOrder toVersionData() {
        CheckOrder order = new CheckOrder(1,"323");
        order.setId(1);
        order.setType("盘点单");
        return order;
    }

    @Override
    Class<CheckOrder> clasz() {
        return CheckOrder.class;
    }
}
