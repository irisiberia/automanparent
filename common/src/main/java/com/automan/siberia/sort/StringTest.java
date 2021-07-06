package com.automan.siberia.sort;

import java.util.Scanner;

/**
 * @Author: he.zhou
 * @Date: 2019-08-08
 */
public class StringTest {

    public static void main(String[] args) {
        String aa = "abe";
        String bb = "cabc";

        int sizeA = aa.length();
        int max = 0;
        for (int i = 0; i < bb.length() - sizeA; i++) {
            String subB = bb.substring(i, i + sizeA);
            int count = campare(aa, subB);
            if (max < count) {
                max = count;
            }
        }
        System.out.println(sizeA - max);


        Scanner cin = new Scanner(System.in);
        char[] a = cin.next().trim().toCharArray(),
                b = cin.next().trim().toCharArray();
        int[][] m = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (i > 0) m[i][j] = Math.max(m[i - 1][j], m[i][j]);
                if (j > 0) m[i][j] = Math.max(m[i][j - 1], m[i][j]);
                if (a[i] == b[j] && a.length - i <= b.length - j && i <= j) {
                    int last = 0;
                    if (i > 0 && j > 0) last = m[i - 1][j - 1];
                    m[i][j] = Math.max(m[i][j], last + 1);
                }
            }
        }
        int common = m[a.length - 1][b.length - 1];
        int add = b.length - a.length;
//    System.out.println(common);
        int ans = b.length - common - add;
        System.out.println(ans);


    }

    private static int campare(String a, String subB) {
        int minLen = Math.min(a.length(), subB.length());
        int conut = 0;
        for (int i = 0; i < minLen; i++) {
            if (a.charAt(i) == subB.charAt(i)) {
                conut++;
            }
        }
        return conut;
    }
}
