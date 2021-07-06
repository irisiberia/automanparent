package com.automan.siberia.sort.treetest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: he.zhou
 * @Date: 2019-07-26
 */
public class shuzu {


//    public static void main(String[] args) {
//        int[] arr = {1, 4, 5, 2, 3, 5, 6};
//        int[] arr2 = {2, 4, 5, 2, 33, 5, 63};
//
//   for (int i:intersect3(arr, arr2)){
//       System.out.println(i);
//   }


//    }

    public static int[] intersect3(int[] nums1, int[] nums2) {


        int len1 = nums1.length;
        int len2 = nums2.length;

        ArrayList<Integer> al = new ArrayList<Integer>();

        for (int i = 0, j = 0; i < len1 && j < len2; ) {
            if (nums1[i] == nums2[j]) {
                al.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] in = new int[al.size()];

        int e = 0;
        for (int i : al) {
            in[e++] = i;
        }
        return in;
    }

//    public static void main(String[] args) {
//        int[] numbers = new int[100];
//        int[] selected = new int[10];
//        int n = numbers.length;
//        for (int i = 0; i < selected.length; i++) {
//            int idx = (int)(Math.random() * n); // 随机产生一个从0 - (n-1)的数字
//            selected[i] = numbers[idx];
//            numbers[idx] = numbers[n - 1];
//            n--; // 减1，从而在下次循环时产生的随机的numbers数组下标的范围从0 - (n-1)-1，
//            // 保证了上一步中已经赋值给数组中其它数的numbers[n-1]不会在下次循环中给
//            // 取得，确保了产生的数组selected中的数为不重复的。
//        }

//    public static void main(String[] args) {
//        System.out.println((int) (Math.random() * 10));
//    }

    public static int commonBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        //定义middle
        int middle = 0;

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                //比关键字大则关键字在左区域
                high = middle - 1;
            } else if (arr[middle] < key) {
                //比关键字小则关键字在右区域
                low = middle + 1;
            } else {
                return middle;
            }
        }
        //最后仍然没有找到，则返回-1
        return -1;
    }
}

