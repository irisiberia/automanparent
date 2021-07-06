package com.automan.siberia;

import org.apache.tools.ant.taskdefs.optional.pvcs.Pvcs;
import sun.misc.Service;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: he.zhou
 * @Date: 2019-01-22
 */
public class quickSort {
    public static int quick(int array[], int low, int high, int k) {
        int i, j;
        int tmp;
        if (low > high) {
            return Integer.MIN_VALUE;
        }
        i = low;
        j = high;
        tmp = array[i];
        while (i < j) {
            while (i < j && array[j] >= tmp)
                j--;
            if (i < j)
                array[i++] = array[j];
            while (i < j && array[i] < tmp)
                i++;
            if (i < j)
                array[j--] = array[i];

        }
        array[i] = tmp;
        if (i + 1 == k)
            return tmp;
        else if (i + 1 > k)
            return quick(array, low, i - 1, k);
        else
            return quick(array, i + 1, high, k);
    }

    public static int getKMin(int array[], int k) {
        if (array == null)
            return Integer.MIN_VALUE;
        if (array.length < k)
            return Integer.MIN_VALUE;
        return quick(array, 0, array.length - 1, k);
    }

    public static int erfen(int[] arr, int target) {
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

    public static int[] sort(int[] arr1, int[] arr2) {
        int lenth1 = arr1.length;
        int lenth2 = arr2.length;

        int[] arr3 = new int[lenth1 + lenth2];
        int i = 0;
        int j = 0;
        for (int k = 0; k < lenth1 + lenth2; k++) {
            if (i >= lenth1) {
                arr3[k] = arr2[j++];
            } else if (j >= lenth2) {
                arr3[k] = arr1[i++];
            } else {
                if (arr1[i] > arr2[j]) {
                    arr3[k] = arr2[j++];
                } else {
                    arr3[k] = arr1[i++];
                }
            }
        }
        return arr3;
    }

    public Node get(Node head) {
        Node prev = null;
        Node now = head;
        while (head.getNext() != null) {
            Node next = head.getNext();
            now.setNext(prev);
            prev = now;
            now = next;
        }
        return prev;
    }


    public Node delete(Node head, int k) {

        Node n1 = head;
        Node n2 = head;
        for (int i = 0; i < k && n1 != null; i++) {
            n1 = n1.getNext();
        }
        while (n1 != null) {
            n1 = n1.getNext();
            n2 = n2.getNext();
        }
        n2.setNext(n2.getNext().getNext());
        return head;
    }


    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap();
        map.put("23", "@3");
        ConcurrentHashMap map1 = new ConcurrentHashMap();
        map1.put("121", "1212");
//        int a[] = {1, 5, 2, 6, 8, 0, 6};
//        int kMin = getKMin(a, 2);
        System.out.println(1);


        int[] yy = {1, 2, 3, 4, 6, 9};
        System.out.println(erfen(yy, 9));


        int[] o = {1, 3, 5, 7, 9, 11, 12};
        int[] t = {2, 4, 6, 8, 10, 13, 14};
        int[] th = sort(o, t);
        System.out.println();

    }
}
