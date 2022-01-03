package com.automan.siberia.sort;

import com.sun.tools.javadoc.Start;
import lombok.Data;

import java.beans.EventHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Testiii {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
//        erfen(arr);
        kuaisu1(arr, 0, arr.length - 1);
        System.out.println();

        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(erfen2(arr2, 1));
        System.out.println(Arrays.toString(arr));

        int[] arr3 = new int[]{4, 5, 6, 7, 1, 2, 3};
        System.out.println(fanzhuan(arr3, 1));


        int[] arr4 = new int[]{5, 6, 7, 4, 3, 2, 1};
        System.out.println(getMax(arr4));

        tets11(arr4);
        System.out.println(Arrays.toString(arr4));

        HashMap map = new HashMap();
        map.get("eewe");

        int[] arr5 = new int[]{1, 3, 5, 8};
        int[] arr6 = new int[]{2, 4, 6, 7};
        System.out.println(Arrays.toString(merge(arr5, arr6)));

        int[] arr7 = new int[]{-1,2,-3,-4,19,-4};
        System.out.println(getMax333(arr7));

    }

    private static void kuaisu(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int temp = arr[low];
        int start = low;
        int end = high;

        while (start < end) {
            while (start < end && arr[end] >= temp) {
                end--;
            }

            while (start < end && arr[start] <= temp) {
                start++;
            }

            if (start < end) {
                int i = arr[end];
                arr[end] = arr[start];
                arr[start] = i;
            }
        }
        arr[low] = arr[start];
        arr[start] = temp;

        kuaisu(arr, low, start - 1);
        kuaisu(arr, start + 1, high);


    }

    public static void erfen(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void maopao(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int erfen2(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Data
    public static class Node {
        private Node next;
        private int data;
    }

    @Data
    public static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;
    }

    /**
     * 翻转有序数组，/|/ 类似这样的结构
     */
    public static int fanzhuan(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                //左边有序
                if (arr[mid] > arr[end]) {
                    if (arr[mid] > target && arr[start] <= target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (arr[mid] < target && arr[end] <= target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 将两个有序链表合并成一个
     */
    public static Node hebing(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node prev;
        if (node1.getData() <= node2.getData()) {
            prev = node1;
            prev.setNext(hebing(node1.getNext(), node2));
        } else {
            prev = node2;
            prev.setNext(hebing(node1, node2.getNext()));
        }
        return prev;
    }

    /**
     * 判断两个二叉树是否相等
     */

    public static boolean iSame(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.getData() != node2.getData()) {
            return false;
        }
        return iSame(node1.getLeft(), node2.getLeft()) &&
                iSame(node1.getRight(), node2.getRight());
    }

    /**
     * 判断二叉树是否对称
     */

    public static boolean isDuiChen(TreeNode node) {
        if (node == null) {
            return false;
        }
        return pnduan(node.getLeft(), node.getRight());
    }

    private static boolean pnduan(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return false;
        }
        if (left.getData() != right.getData()) {
            return false;
        } else {
            return pnduan(left.getLeft(), right.getRight())
                    && pnduan(left.getRight(), right.getLeft());
        }
    }


    public Node fanzhuan(Node head) {
        Node prev = null;
        Node now = head;
        while (now != null) {
            Node next = now.getNext();
            now.setNext(prev);
            prev = now;
            now = next;
        }
        return prev;
    }

    public boolean hasHuan(Node node) {
        Node slow = node;
        Node quick = node;
        while (quick != null && quick.getNext() != null) {
            quick = quick.getNext().getNext();
            slow = slow.getNext();
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 先递增后抵减数组最大值
     */

    public static int getMax(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 奇数在前面，偶数在后面
     */
    public static void tets11(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            while (start < end && arr[end] % 2 == 0) {
                end--;
            }
            while (start < end && arr[start] % 2 != 0) {
                start++;
            }
            if (start < end) {
                int i = arr[start];
                arr[start] = arr[end];
                arr[end] = i;
            }
        }
    }

    /**
     * 两个有序数组合并成一个有序数组
     */
    private static int[] merge(int[] arr1, int[] arr2) {
        int three = arr1.length + arr2.length;
        int i = 0;
        int j = 0;
        int[] arr3 = new int[three];
        for (int k = 0; k < three; k++) {
            if (i >= arr1.length) {
                arr3[k] = arr2[j++];
            } else if (j >= arr2.length) {
                arr3[k] = arr1[i++];
            } else {
                if (arr1[i] >= arr2[j]) {
                    arr3[k] = arr2[j++];
                } else {
                    arr3[k] = arr1[i++];
                }
            }
        }
        return arr3;
    }

    /**
     * 连续子数组和最大
     * <p>
     * Max dp[i]=Max{dp[i-1]+arr[i],arr[i]}
     */
    public static int getMax333(int[] arr) {
        int max = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max + arr[i], arr[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    private static void kuaisu1(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }

        int temp = arr[low];
        int start = low;
        int end = high;

        while (start < end) {
            while (start < end && arr[end] >= temp) {
                end--;
            }
            while (start < end && arr[start] <= temp) {
                start++;
            }
            if (start < end) {
                int i = arr[start];
                arr[start] = arr[end];
                arr[end] = i;
            }
        }

        arr[low] = arr[start];
        arr[start] = temp;
        kuaisu1(arr, low, start - 1);
        kuaisu1(arr, start + 1, high);


    }


}
