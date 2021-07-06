package com.automan.siberia.abstractOrderService;

import org.springframework.stereotype.Component;

/**
 * @Author: he.zhou
 * @Date: 2018-12-24
 */
@Component
public class CheckOrder extends AbstractOrderBiz {

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
}
