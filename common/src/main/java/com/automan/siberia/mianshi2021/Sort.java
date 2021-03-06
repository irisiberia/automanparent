package com.automan.siberia.mianshi2021;

import com.automan.siberia.Node;

import java.util.EmptyStackException;
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
     * 获取有环链表的第一个节点
     * <p>
     * 第一次相遇时，让quick等于头结点，下次相遇的时候就是环的头几点
     *
     * @param head
     * @return
     */
    public Node hasLoop(Node head) {
        Node quick = head;
        Node slow = head;
        while (quick != null && quick.getNext() != null) {
            quick = quick.getNext().getNext();
            slow = slow.getNext();
            if (slow == quick) {
                break;
            }
        }

        quick = head;
        while (quick != slow) {
            quick = quick.getNext();
            slow = slow.getNext();
        }
        return quick;
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
            Node next = head.getNext();
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
        int count = 0;
        while (p1.getNext() != null) {
            count++;
            if (count <= k) {
                p1 = p1.getNext();
            } else {
                p1 = p1.getNext();
                p2 = p2.getNext();
            }
        }
        if (head.getNext() == null || count + 1 == k) {
            head = head.getNext();
        } else {
            p1.setNext(p1.getNext().getNext());
        }
        return head;


    }

    /**
     * 01234567
     * <p>
     * --->
     * <p>
     * 5678901234
     */
    public static int serch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                if (arr[mid] > arr[end]) {
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

    /**
     * 先递增后递减数组找到最大值
     */

    public static int serch2(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 6, 8, 9, 12, 16};
        int[] arr1 = new int[]{1, 3, 4, 6, 8, 9, 12, 16};

        int[] arr2 = new int[]{5, 6, 7, 0, 1, 2, 3, 4};
        int[] merge = merge(arr, arr1);
        System.out.println(serch(arr2, 7));
        System.out.println(binarySearch(arr, 16));
    }
}
