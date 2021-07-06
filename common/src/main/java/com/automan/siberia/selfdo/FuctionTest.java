package com.automan.siberia.selfdo;


import java.util.function.Function;

/**
 * @Author: he.zhou
 * @Date: 2018-11-07
 */
public class FuctionTest {

    public static String invokeRule2(Integer input, Function<Integer, String> function) {
        if (input>3){
            return "错误";
        }
        String ssss="";
        for (int i=1;i<6;i++){
            String ss = function.apply(input);
            ssss=ssss+ss;
        }

        return ssss;
    }


    public static void main(String[] args) {
        Function<Integer, String> function = x -> {
            return String.valueOf(x) + "jhggjg";
        };


        System.out.println(function.apply(4));
        String ars = invokeRule2(2, ar -> ar.toString() + "hkhi");

        String arss = invokeRule2(4, new Function<Integer, String>() {
                @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        });
        System.out.println(ars);
    }
}
