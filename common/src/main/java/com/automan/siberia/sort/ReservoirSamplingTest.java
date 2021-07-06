package com.automan.siberia.sort;

import org.aspectj.lang.annotation.Before;

import java.util.Random;

/**
 * @Author: he.zhou
 * @Date: 2017-07-29
 */
public class ReservoirSamplingTest {

    // 所有数据
    private static int[] pool;

    // 数据规模
    private static final int N = 100;
    private static Random random = new Random();


    /**
     * 蓄水池
     *
     * @param K
     * @return
     */
    private static int[] sampling(int K) {
        // 初始化
        pool = new int[N];
        for (int i = 0; i < N; i++) {
            pool[i] = i;
        }

        int[] result = new int[K];
        // 前 K 个元素直接放入数组中
        for (int i = 0; i < K; i++) {
            result[i] = pool[i];
        }

        // K + 1 个元素开始进行概率采样
        for (int i = K; i < N; i++) {
            int r = new Random().nextInt(i + 1);
            if (r < K) {
                result[r] = pool[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        for (int i : sampling(1)) {
            System.out.println(i);
        }
    }

}
