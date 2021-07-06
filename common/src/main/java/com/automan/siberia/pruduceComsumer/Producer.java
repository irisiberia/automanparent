package com.automan.siberia.pruduceComsumer;

import java.util.HashMap;

public class Producer implements Runnable {
    Cleck cleck;

    public Producer(Cleck cleck) {
        this.cleck = cleck;
    }

    @Override
    public  void run() {
        HashMap map=new HashMap();
        map.get("ww");
        map.put("ee","ee");
        System.out.println("生产者开始生产产品");
        while (true){
            try {
                Thread.sleep(1000);
                cleck.addProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
