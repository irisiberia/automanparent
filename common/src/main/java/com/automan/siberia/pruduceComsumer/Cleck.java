package com.automan.siberia.pruduceComsumer;


public class Cleck {
    int product;
    int productNum;

    //消费
    public synchronized void conProduct() throws InterruptedException {
        if (product <= 0) {
            wait();
        } else {
            System.out.println(Thread.currentThread().getName() + "消费了第" + product + "个产品");
            product--;
            notify();
        }

    }

    //生产
    public synchronized void addProduct() throws InterruptedException {
        if (product >= 20) {
            wait();
        } else {
            product++;
            System .out.println(Thread.currentThread().getName() + "生产了第" + product + "个产品");
            notify();
        }
    }


}
