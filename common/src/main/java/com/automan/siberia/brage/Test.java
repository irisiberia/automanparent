package com.automan.siberia.brage;

/**
 * @Author: he.zhou
 * @Date: 2019-04-11
 */
public class Test {
    public static void main(String[] args) {
        CarColor carColor = new RedCar();

        CarColor carColor1 = new BlueCar();


        Car car = new BmwCar(carColor);

        Car car1 = new BmwCar(carColor1);
        car1.creatCar();
        car.creatCar();

    }
}
