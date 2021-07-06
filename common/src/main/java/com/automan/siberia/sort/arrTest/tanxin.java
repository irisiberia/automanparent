package com.automan.siberia.sort.arrTest;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * @Author: he.zhou
 * @Date: 2019-08-08
 */
public class tanxin {
    /**
     * 数组排序：贪心
     * 一个无序数组，每次只能执行一种操作：把任意一个元素移动到末尾。问最少经过多少次操作能够使得数组变得有序。
     * <p>
     * 对于元素x，只要它后面有比它小的元素，它就必然要被挪到最后去。而对于需要挪到最后去的一批元素，必然是优先移动比较小的那些元素，这样才能保证它们尽量靠前。
     *
     * @param args
     */
    public static void main(String[] args) {


        int[] a = new int[]{2, 11, 3, 10, 4, 5,9 };
        int s = 0;
        while (true) {
            LinkedList<Integer> left = new LinkedList<>();
            LinkedList<Integer> right = new LinkedList<>();
            int mi = Integer.MAX_VALUE;
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i]>mi) {
                    right.add(a[i]);
                } else {
                    left.add(a[i]);
                }
                mi = Math.min(mi, a[i]);
            }
            right.sort(Comparator.comparing(x -> x));
            s += right.size();
            if (right.size() == 0) {
                break;
            }
            int ai = 0;
            for (int i : left) {
                a[a.length - 1 - right.size() - (ai++)] = i;
            }
            for (int i : right) {
                a[ai++] = i;
            }
        }

        System.out.println(s);
    }
}
