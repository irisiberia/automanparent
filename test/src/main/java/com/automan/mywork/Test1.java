package com.automan.mywork;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(getMaxLengthStr("123456879515244klfj45678lkaEsd234568EEASs"));
    }

    public static String getMaxLengthStr(String inputStr) {
        int lastlen = 0;
        String sResult = "";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(inputStr);
        while (m.find()) {

            String temp = m.group();
            if (temp.length() > lastlen) {
                lastlen = temp.length();
                sResult = temp;
            }
            lastlen = temp.length();
        }
        return sResult;
    }
}
