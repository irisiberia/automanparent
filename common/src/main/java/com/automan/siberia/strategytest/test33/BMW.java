package com.automan.siberia.strategytest.test33;

public class BMW extends Car {
    public BMW(Prise prise, Color color) {
        super(prise, color);
    }

    @Override
    public String creatCar() {
        return "宝马" + color.getColor() + prise.pay();
    }
}
