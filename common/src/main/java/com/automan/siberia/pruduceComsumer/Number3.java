package com.automan.siberia.pruduceComsumer;

public class Number3 {
    private static int num = 1;


    private void one() {
        while (num <= 100) {
            synchronized (this) {
                if (num % 2 == 0) {

                }
            }
        }
    }
}
