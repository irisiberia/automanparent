package com.automan.siberia.sort.nodeTest;

import com.automan.siberia.Node;

/**
 * 链表归并排序
 */
public class MergeSort {

    /**
     * 找到中间点，分割
     *
     * @param head
     * @return
     */
    public static Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
        //快慢指针
        Node slow, fast;
        slow = fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }


    /**
     * 合并排好序的链表
     */
//    public static Node merge(Node<Integer> a, Node<Integer> b) {
//        Node<Integer> dummyHead;
//        Node curr;
//        dummyHead = new Node<>(0);
//        curr = dummyHead;
//        while (a != null && b != null) {
//            if (a.getData() <= b.getData()) {
//                curr.setNext(a);
//                a = a.getNext();
//            } else {
//                curr.setNext(b);
//                b = b.getNext();
//            }
//            curr = curr.getNext();
//        }
//        curr.setNext((a == null) ? b : a);
//        return dummyHead.getNext();
//    }
    public static Node<Integer> mergeTwoListByRecursive(Node<Integer> n1, Node<Integer> n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        Node<Integer> head;
        if (n1.getData() < n2.getData()) {
            head = n1;
            head.setNext(mergeTwoListByRecursive(n1.getNext(), n2));
        } else if (n1.getData() == n2.getData()) {
            head = n1;
            head.setNext(mergeTwoListByRecursive(n1.getNext(), n2.getNext()));
        } else {
            head = n2;
            head.setNext(mergeTwoListByRecursive(n1, n2.getNext()));
        }
        return head;
    }


    /**
     * 单链表的归并排序
     *
     * @param head
     * @return
     */
    public static Node merge_sort(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        //得到链表中间的数
        Node middle = getMiddle(head);
        Node sHalf = middle.getNext();
        //拆分链表
        middle.setNext(null);
        //递归调用
        return mergeTwoListByRecursive(merge_sort(head), merge_sort(sHalf));
    }

    public static Node merge_sort1(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextHalf = middle.getNext();
        middle.setNext(null);

        return mergeTwoListByRecursive(merge_sort(head), merge_sort(nextHalf));

    }

    public static void main(String[] args) {
        Node head = new Node(8);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(4);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(7);
        Node<Integer> node5 = new Node<>(1);
        Node<Integer> node6 = new Node<>(6);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        System.out.println("=======");

        Node head1 = merge_sort(head);
        while (null != head1) {
            System.out.print(head1.getData() + " ");
            head1 = head1.getNext();
        }
    }


}
