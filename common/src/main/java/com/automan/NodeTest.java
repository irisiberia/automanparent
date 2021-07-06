package com.automan;

import com.automan.siberia.Node;

import java.util.EmptyStackException;
import java.util.Stack;

public class NodeTest {

    public static Node delete(Node head, int k) {
        if (k < 0) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k && p1 != null; i++) {
            p1 = p1.getNext();
        }
        while (p1 != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        p2.setNext(p2.getNext().getNext());
        return head;
    }

    public static Boolean isHuiwen(Node head) {
        //找到中间节点
        Node p1 = head;
        Node p2 = head;
        while (p1 != null && p1.getNext() != null) {
            p1 = p1.getNext().getNext();
            p2 = p2.getNext();
        }

        Stack<Node> stack = new Stack<>();
        while (p2 != null) {
            p2 = p2.getNext();
            stack.push(p2);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(head)) {
                return false;
            }
            head = head.getNext();
        }
        return true;
    }


    public static int erfen(int[] arr, int target) {
        int end = arr.length - 1;
        int start = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {27, 76, 47, 23, 7, 32, 19, 86};
        System.out.println("************冒泡排序************");
        System.out.println("排序前：");
        erfen(list);
        System.out.println("排序后：");
        for (int i = 0; i < list.length - 1; i++) {
            System.out.println(list[i]);

        }
    }

    public static void erfen(int[] arr) {
        int l = arr.length - 1;
        for (int i = 0; i <l-1; i++) {
            for (int j = 0; j <l-1-j; j++) {


            }

        }
    }

    public static void kuaisu(int[] arr){

    }


}
