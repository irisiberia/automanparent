package com.automan.siberia.abstractOrderService;

import javax.annotation.PostConstruct;

/**
 * @Author: he.zhou
 * @Date: 2018-12-24
 */
public abstract class AbstractOrderBiz implements OrderBiz {

    private int tableId;

    @Override
    public String generate() {
        generateCheck();
        String order = queryById() + "生单成功";
        endOrder();
        return order;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String queryById() {
        if (getOrdrType().equals("Expire")) {
            return "456789";
        } else if (getOrdrType().equals("Check")) {
            return "check";
        }
        return "123345";
    }

    @Override
    public String test() {
        return String.valueOf(setTableId());
    }

    abstract String getOrdrType();

    abstract void generateCheck();

    abstract void endOrder();

    abstract int setTableId();

}
