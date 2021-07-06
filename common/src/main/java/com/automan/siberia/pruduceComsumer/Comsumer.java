package com.automan.siberia.pruduceComsumer;

public class Comsumer implements Runnable{

    Cleck cleck;

    public Comsumer(Cleck cleck) {
        this.cleck = cleck;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费产品");
        while (true){
            try {
                Thread.sleep(3000);
                cleck.conProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
