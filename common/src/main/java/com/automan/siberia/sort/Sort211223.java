package com.automan.siberia.sort;

import com.automan.siberia.Node;

/**
 * @Author he.zhou
 * @Date 2021-12-23
 */
public class Sort211223 {

    public static void main(String[] args) {
        int i = iSame(new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6}, 6);
        System.out.println();
    }

    public static int getMax333(int[] arr) {
        int max = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {

            max = Math.max(max + arr[i], arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }


    public static int iSame(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                // 落在左边
                if (arr[start] < arr[mid]) {
                    if (arr[mid] > target && arr[start] <= target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (arr[mid] < target && arr[end] >= target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

            }
        }
        return -1;
    }

    public static Node delete(Node head, int k) {
        if (k < 0) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k & p1 != null; i++) {
            p1 = p1.getNext();
        }

        while (p1 != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        p2.setNext(p2.getNext().getNext());
        return head;
    }

    public static boolean isDuiChen(Testiii.TreeNode node) {
        if (node == null) {
            return false;
        }
        return false;
    }

}
