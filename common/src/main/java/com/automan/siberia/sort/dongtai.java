package com.automan.siberia.sort;

import java.util.Scanner;

/**
 * @Author: he.zhou
 * @Date: 2019-08-08
 */
public class dongtai {

    /**
     * N个人，M个礼品，每个礼品的个数为C[i]，第i个人选择第j个礼品的概率为p[i][j]，当发放礼品时，N个人一次性确定好自己要什么礼品，然后按照顺序一次发放，若某种类型的礼品没了，就不给要这个礼品的人发了。因为礼品个数有限，问期望有多少人能够拿到礼品。
     * <p>
     * 关键在于明白问题转化：期望拿到礼品的人数=每种礼品期望发给的任务。因为人和礼品之间时一一对应的。
     * 定义数组f[M][N],f[i][j]表示第i种礼品被要求次数为j的概率，N从0~N递增推导就可以得到最终矩阵，这个过程相当于滚动数组形式的动态规划。
     * ¬
     *
     * @param args
     */
    public static void main(String[] args) {

        int N, M;
        int[] c;
        double p[][];
        double left[][];

        Scanner cin = new Scanner(System.in);
        N = cin.nextInt();
        M = cin.nextInt();
        c = new int[M];
        p = new double[N][M];
        for (int i = 0; i < M; i++) {
            c[i] = cin.nextInt();
            if (c[i] > N) c[i] = N;
        }
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) p[i][j] = cin.nextDouble();
        left = new double[M][N + 1];
        for (int i = 0; i < left.length; i++) left[i][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = N; k >= 0; k--) {
                    left[j][k] = left[j][k] * (1 - p[i][j]);
                    if (k > 0) {
                        left[j][k] += left[j][k - 1] * p[i][j];
                    }
                }
            }
        }
        double s = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j <= N; j++) {
                s += left[i][j] * Math.min(c[i], j);
            }
        }
        System.out.printf("%.1f", s);
    }
}
