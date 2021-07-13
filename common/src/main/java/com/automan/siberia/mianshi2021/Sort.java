package com.automan.siberia.mianshi2021;

import com.automan.siberia.Node;

import java.util.Stack;

/**
 * @Author he.zhou
 * @Date 2021-07-13
 */
public class Sort {

    public static Stack<Integer> stack1 = new Stack();
    public static Stack<Integer> stack2 = new Stack();

    public void push(Integer value) {
        stack1.push(value);
    }

    public Integer pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public static int binarySearch(int[] arr, int toFind) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == toFind) {
                return mid;
            } else if (arr[mid] > toFind) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 合并两个有序数组
     *
     * @param arr1
     * @param arr2
     */
    public static int[] merge(int[] arr1, int[] arr2) {

        int onesize = arr1.length;
        int twosize = arr2.length;
        int threesize = onesize + twosize;
        int[] three = new int[threesize];
        int i = 0;
        int j = 0;
        for (int k = 0; k < threesize; k++) {
            if (i >= onesize) {
                three[k] = arr2[j++];
            } else if (j >= twosize) {
                three[k] = arr1[i++];
            } else {
                if (arr1[i] <= arr2[j]) {
                    three[k] = arr1[i++];
                } else {
                    three[k] = arr2[j++];
                }
            }
        }
        return three;
    }

    /**
     * 判断是否有环
     *
     * @param head
     * @return
     */
    public boolean hasLoop(Node head) {
        Node quick = head;
        Node slow = head;
        while (head != null && quick.getNext() != null) {
            quick = quick.getNext().getNext();
            slow = slow.getNext();
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 单链表反转
     *
     * @param head
     * @return
     */
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

    /**
     * 单链表是否回文
     */
    public boolean huiwen(Node head) {
        Node quick = head;
        Node slow = head;

        while (quick != null && quick.getNext() != null) {
            quick = quick.getNext().getNext();
            slow = slow.getNext();
        }

        Stack<Node> stack = new Stack<Node>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.getNext();
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(head)) {
                return false;
            }
            head = head.getNext();
        }
        return true;
    }

    /**
     * 删除单链表倒数第k个节点
     */
    public Node delete(Node head, int k) {
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k - 1 && p1 != null; i++) {
            p1 = p1.getNext().getNext();
            p2 = p2.getNext();
        }
        while (p1 != null) {
            p1 = p1.getNext().getNext();
            p2 = p2.getNext();
        }
        p2.setNext(p2.getNext().getNext());
        return head;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 6, 8, 9, 12, 16};
        int[] arr1 = new int[]{1, 3, 4, 6, 8, 9, 12, 16};
        int[] merge = merge(arr, arr1);
        System.out.println(binarySearch(arr, 16));
    }
}
