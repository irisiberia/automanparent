package com.automan.siberia.sort.arrTest;

import java.util.Arrays;

import static java.lang.Math.incrementExact;
import static java.lang.Math.max;

/**
 * 两个有序数组合并成一个有序数组
 */
public class MustLook {
    public static int[] sort(int[] arr1, int[] arr2) {
        int onesize = arr1.length;
        int twosize = arr2.length;
        int threesize = onesize + twosize;
        int[] three = new int[threesize];
        int i = 0;
        int j = 0;
        for (int t = 0; t < threesize; t++) {
            if (i >= onesize) {   //如果第一个数组比较完了，直接把第二个数组后面的数，排序到后面
                three[t] = arr2[j++];
            } else if (j >= twosize) {  //如果第二个数组比较完了，直接把第一个数组后面的数，排序到后面
                three[t] = arr1[i++];
            } else {
                if (arr1[i] <= arr2[j]) {
                    three[t] = arr1[i++];
                } else {
                    three[t] = arr2[j++];
                }
            }
        }
        return three;
    }

    public static void main(String[] args) {
        int[] o = {1, 3, 5, 7, 9, 11, 12};
        int[] t = {2, 4, 6, 8, 10, 13, 14};
        int[] th = sort(o, t);
        System.out.println(Arrays.toString(th));

        int[] yy = {1, 2, 3, 4, 5, 9, 8, 6};
        System.out.println(search22(yy, 9));

        int[] cc = {3, 9, 4, 5, 3};
        System.out.println(rob(cc));


    }


    /**
     * 连续子数组的最大和
     * <p>
     * 动态规划
     * <p>
     * (继承前人遗产吗) 当我们往后扫描时，对第j+1个元素有两种选择——要么放入前面找到的子数组，要么做为新子数组的第一个元素：
     * 1.1 如果currSum+当前元素a[j] >= a[j]，则令currSum加上a[j]
     * 1.2 否则currSum重新赋值，置为下一个元素，即currSum = a[j]。
     * (更新历代最强吗) 比较当前最大子数组和与最大子数组的和：
     * 2.1 同时，当currSum > maxSum，则更新maxSum = currSum
     * 2.2 否则保持原值，不更新。
     * 即
     * curSum = max(a[j], curSum + a[j])
     * maxSum = max(maxSum, curSum)
     * <p>
     * 举个例子，当输入数组是1, -2, 3, 10, -4, 7, 2, -5，那么，curSum和maxSum相应的变化为：
     * curSum ： 0 | 1 -1 3 13 9 16 18 13
     * maxSum ： 1 | 1 1 3 13 13 16 18 18
     *
     * @param arr
     * @return
     */
    public static int findGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("Array must contain an element");
        }
        int curSum = 0;
        int maxSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            curSum = max(arr[i], curSum + arr[i]);//1---------
            maxSum = max(maxSum, curSum);//2---------
        }
        return maxSum;
    }


    /**
     * 题目： 给定一个旋转数组，但是你不知道旋转位置，在旋转数组中找出给定target值出现的位置；你可以假设在数组中没有重复值出现
     * <p>
     * 举例：
     * <p>
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p>
     * 在旋转后的数组中查找6，则返回index =2. 若查找10，则返回index= -1；
     * <p>
     * 解题思路：
     * <p>
     * 由于数组中没有重复出现的数字，因此旋转后的数组基本可以划分为两部分；因此解题思路可以转换为我们熟悉的二分查找；但是在二分查找时我们需要注意，到底在哪边查找？
     * <p>
     * 1） 假设此时在[start, end]之间查找，则mid = (start + end) / 2;此时有三种情况，即nums[mid] > target, nums[mid] < target, nums[mid] = target;
     * <p>
     * 2)   nums[mid] > target这种情况下，如何缩小start或者end的范围呢？
     * <p>
     * a)     456789123, nums[mid] = 8, target =2,
     * 此时判断条件应当是nums[start] > nums[end]（表示将原数组将数组划分为两部分，
     * 第一部分是升序，第二部分也是升序）&& nums[mid] > = nums[start](表示[start, mid]之间的数是一个严格的升序) && target < nums[start](表示所求的值在第二部分的升序中)，
     * 此时将所有的条件整合起来，则可判断要找的值一定在后半段
     * ，即start = mid + 1；否则end = mid -1
     * <p>
     * 3)  nums[mid] < target的情况用同样的方法去除一半
     * <p>
     * 但是要注意每次缩小的一半一定是一个升序或者降序；
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target < nums[mid]) {
                if (nums[start] > nums[end] && nums[mid] >= nums[start] && target < nums[start]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (target > nums[mid]) {
                if (nums[start] > nums[end] && nums[mid] < nums[end] && target > nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 本题依然使用二分法，难点在于如何判断 target 在前半段还是后半段。
     * 对于无重复的数组4 5 6 7 0 1 2，如果满足 A[begin] <= A[mid] ，即数组的第一个值小于中间值 4 < 7 ，那么可以断定前半段数组有序。
     * 如果不满足这个条件，(比如：4 5 0 1 2) 则说明后半段有序。
     * 因为把这个数组从中间分开后，一定至少有半个数组是有序的。然后再判断 target 是否在有序的半段中（这个很好判断），
     * 如果在，则相当于在有序数组中查找，很简单。如果不在有序的那半段，则一定在另外半段里。
     * 然后使用迭代即可把target找出。
     *
     * @param arr
     * @param target
     * @return
     */
    public int searchTset(int[] arr, int target) {
        int count = arr.length;
        int left = 0;
        int right = count - 1;
        while (left <= right) {  // 高级版的二分查找
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                //左边有序
                if (arr[mid] > arr[right]) {
                    if (arr[mid] > target && arr[left] <= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (arr[mid] < target && arr[right] >= target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }


    // // 右边有序
    //                if (nums[mid] < nums[right]) {
    //                    //判断target是否在后半段，如果在，则继续遍历后半段，如果不在后半段，则继续遍历前半段
    //                    if (nums[mid] < target && nums[right] >= target) {
    //                        left = mid + 1;
    //                    } else {
    //                        right = mid - 1;
    //                    }
    //                } else { // 左边有序
    //                    //判断target是否在前半段，如果在，则继续遍历前半段，如果不在，则继续遍历后半段
    //                    if (nums[mid] > target && nums[left] <= target) {
    //                        right = mid - 1;
    //                    } else {
    //                        left = mid + 1;
    //                    }
    //                }

    /**
     * 求先递增后递减数组最大值的下标
     *
     * @param nums
     * @return
     */
    public static int get_max(int[] nums) {
        if (nums != null && nums.length > 0) {
            if (nums.length == 1) {
                return 0;
            }
            if (nums[0] > nums[1]) {//数组单调递减
                return 0;
            }
            int index = nums.length - 1;
            if (nums[index] > nums[index - 1]) {//数组单调递增
                return index;
            }
            int i = 0,
                    j = index;
            int mid = 0;
            while (i <=j) {//
                // 二分查找
                mid = (i + j) / 2;
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] > nums[mid + 1]) {//处于下坡段, 即递减段
                    j = mid - 1;
                } else if (nums[mid] > nums[mid - 1]) {//处于上坡段, 即递增段
                    i = mid + 1;
                }
            }
        }
        return -1;
    }


    public static int search22(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        int pivot = nums[0],
                size = nums.length,
                mididx = size,
                s = 0,
                e = size - 1;
        if (nums[size - 1] <= pivot) {
            int S = 0, E = size - 1;
            while (S <= E) {
                int mid = (S + E) / 2;
                if (nums[mid] >= pivot)
                    S = mid + 1;
                else
                    E = mid - 1;
            }
            mididx = S;
            if (mididx > size - 1) {
                mididx = 0;
            }
            if (nums[size - 1] >= target) {
                s = mididx;
                e = max(size - 1, s);
            } else {
                s = 0;
                e = max(mididx - 1, s);
            }
        }
        while (s < e) {
            int mid = (s + e) / 2;
            if (nums[mid] < target)
                s = mid + 1;
            else
                e = mid;
        }
        if (s >= size) return -1;
        if (nums[s] == target)
            return s;
        return -1;
    }

    public static boolean isPalindrome(String str) {
        if (str.equals(""))
            return true;
        str = str.toLowerCase();//将字符串的所有大写字母转小写
        int start = 0, end = str.length() - 1;

        //从字符两端分别逐个对比字符，不同则直接返回false
        while (start < end) {
            //过滤掉非字母和数字字符
            while (!(str.charAt(start) >= 'a' && str.charAt(start) <= 'z' || str.charAt(start) >= '0' && str.charAt(start) <= '9'))
                start++;
            //过滤掉非字母和数字字符
            while (!(str.charAt(end) >= 'a' && str.charAt(end) <= 'z' || str.charAt(end) >= '0' && str.charAt(end) <= '9'))
                end--;
            //若字符不同，则直接返回false
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }


    /**
     * 数组取不相邻元素，和最大
     *
     * @param nums
     * @return
     */
    static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

         /*
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < n; i++){
            if(i % 2){
                sum1 = max(sum2,sum1 + nums[i]);
            }else
                sum2 = max(sum1,sum2 + nums[i]);
        }
        return max(sum1,sum2);*/
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < n; i++) {
            int tmp = sum1;
            sum1 = nums[i] + sum2;  //抢这栋房子
            sum2 = Math.max(tmp, sum2);  //不抢这栋房子
        }
        return max(sum1, sum2);
    }

    /**
     * 一个整数数组，调整数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
     */
    public static void ReorderOddEven(int[] datas) {
        if (datas == null || datas.length <= 0) {
            return;
        }
        int begin = 0;
        int end = datas.length - 1;
        int temp = -1;

        while (begin < end) {
            // 向后移动begin，直到它指向偶数
            while (begin < end && datas[begin] % 2 != 0) {
                begin++;
            }
            // 向前移动pEnd，直到它指向奇数
            while (begin < end && datas[end] % 2 == 0) {
                end--;
            }
            if (begin < end) {
                // 交换偶数和奇数
                temp = datas[begin];
                datas[begin] = datas[end];
                datas[end] = temp;
            }
        }
    }
}




