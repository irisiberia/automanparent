package com.automan.siberia.brage;

/**
 * @Author: he.zhou
 * @Date: 2019-04-11
 */
public abstract class Car {

    public CarColor carColor;

    public Car(CarColor carColor) {
        this.carColor = carColor;
    }

    public abstract void creatCar();
}
