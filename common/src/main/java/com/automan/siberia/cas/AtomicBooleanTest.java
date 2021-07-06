package com.automan.siberia.cas;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: he.zhou
 * @Date: 2019-04-15
 */
public class AtomicBooleanTest implements Runnable{

    private static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        AtomicBooleanTest ast = new AtomicBooleanTest();
        Thread thread1 = new Thread(ast);
        Thread thread = new Thread(ast);
        thread1.start();
        thread.start();
    }
    @Override
    public void run() {
        while (true){
            if (flag.compareAndSet(true,false)){

                System.out.println(Thread.currentThread().getName()+"获得到锁："+flag.get());

                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag.set(true);
                break;
            }else{

                System.out.println("重试机制thread:"+Thread.currentThread().getName()+";flag:"+flag.get());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
