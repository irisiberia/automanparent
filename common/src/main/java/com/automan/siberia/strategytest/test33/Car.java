package com.automan.siberia.strategytest.test33;

public abstract class Car {

    protected Prise prise;

    protected Color color;

    public Car(Prise prise, Color color) {
        this.prise = prise;
        this.color = color;
    }

    public abstract String creatCar();
}
