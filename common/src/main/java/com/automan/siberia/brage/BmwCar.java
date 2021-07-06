package com.automan.siberia.brage;

/**
 * @Author: he.zhou
 * @Date: 2019-04-11
 */
public class BmwCar extends Car {

    public BmwCar(CarColor carColor) {
        super(carColor);
    }

    @Override
    public void creatCar() {
        System.out.println("BMW" + "----" + carColor.color());
    }
}
