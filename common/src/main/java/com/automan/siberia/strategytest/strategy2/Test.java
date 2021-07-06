package com.automan.siberia.strategytest.strategy2;

public class Test {


    public static void main(String[] args) {
        PushData pushData=new PushData() {
            @Override
            int type() {
                return 0;
            }

            @Override
            String pushData() {
                return null;
            }
        };
    }
}
