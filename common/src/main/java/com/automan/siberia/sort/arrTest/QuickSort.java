package com.automan.siberia.sort.arrTest;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @Author: he.zhou
 * @Date: 2019-07-07
 */
public class QuickSort {


    public static void sort(int[] arr, int low, int high) {
        int begin, end, temp;
        if (low > high) {
            return;
        }
        temp = arr[low]; //temp中存的就是基准数
        begin = low;
        end = high;
        //条件是<
        while (begin < end) { //顺序很重要，要先从右边开始找
            while (arr[end] >= temp && begin < end) {
                end--;
            }
            while (arr[begin] <= temp && begin < end)//再找左边的
            {
                begin++;
            }
            if (begin < end)//交换两个数在数组中的位置
            {
                int t = arr[begin];
                arr[begin] = arr[end];
                arr[end] = t;
            }
        }
        //最终将基准数归位
        arr[low] = arr[begin];
        arr[begin] = temp;

        sort(arr, low, begin - 1);//继续处理左边的，这里是一个递归的过程
        sort(arr, begin + 1, high);//继续处理右边的 ，这里是一个递归的过程
    }

    public static void main(String[] args) {
//        sort(0, arr.length - 1);
        int[] arr = {6};
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println(binarySearch(arr, 6));


    }


    /**
     * 快速排序
     *
     * @param arr
     * @param low
     * @param high
     */
    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr, 0, index - 1);
            quickSort(arr, index + 1, high);
        }

    }

    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }


    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            System.out.println("第" + (i + 1) + "趟");
            //增加判断位
            boolean flag = true;
            for (int j = 0; j < len - 1 - i; j++) {
                System.out.println("第" + (j + 1) + "次");

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
                System.out.println(Arrays.toString(arr));
            }
            //如果上面没有执行直接退出
            if (flag) {
                break;
            }
        }
    }

    /**
     * 二分查找
     */
    public static int binarySearch(int[] arr, int toFind) {
        int low = 0;
        int high = arr.length - 1;
        if (low > high || toFind < arr[low] || toFind > arr[high]) {
            return -1;
        }
        int mid;
        //条件是 <=
        while (low <= high) {
            mid = (low + high) / 2;
            if (toFind == arr[mid]) {
                return mid;
            } else if (toFind < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}


