package com.automan.siberia.mianshi2021;

import com.automan.siberia.Node;
import org.omg.CORBA.INTERNAL;

/**
 * @Author he.zhou
 * @Date 2021-12-07
 */
public class tttt {


    public static int ssdsd(int[] arr) {
        int max = arr[0];
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max + arr[i], arr[i]);
            res = Math.max(max, res);
        }
        return res;
    }


    public Node fanzhuan(Node head) {
        Node now = head;
        Node prev = null;

        while (head != null) {
            Node next = head.getNext();
            now.setNext(prev);
            prev = now;
            now = next;
        }
        return prev;
    }

    public boolean youhuan(Node head) {
        Node quick = head;
        Node slow = head;

        while (head != null && head.getNext() != null) {
            quick = quick.getNext().getNext();
            slow = slow.getNext();
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }

    public static int binarySearch(int[] arr, int toFind) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[toFind] > toFind) {
                right = mid - 1;
            } else if (arr[left] < toFind) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void maopao(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - 1; j++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
}
