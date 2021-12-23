package com.automan.siberia.sort;

import com.automan.siberia.Node;
import com.automan.siberia.sort.treetest.TreeNode;
import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.Objects;
import java.util.Stack;

/**
 * @Author: he.zhou
 * @Date: 2018-10-26
 * <p>
 * 单链表算法题
 * <p>
 */
public class NodeTest {

    /**
     * 递归
     * 两个有序链表进行合并
     * 考虑重复元素
     *
     * @param n1
     * @param n2
     * @return
     */
    public static Node<Integer> mergeTwoListByRecursive(Node<Integer> n1, Node<Integer> n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        Node head;
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

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(0);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        Node reNode = removeElements(head, 2);
        while (reNode != null) {
            System.out.print(reNode.getData());
            reNode = reNode.getNext();
        }
        System.out.println("============");

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        head = Reverse1(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }

        System.out.println("\n**************************");
        System.out.println("倒数第K个 ：" + method(node1, 2).getData());
        System.out.println(hasLoop(head));
    }

    /**
     * 单链表翻转
     * 递归，在反转当前节点之前先反转后续节点
     */
    public static Node Reverse1(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            // 若为空链或者当前结点在尾结点，则直接还回
            return head;
        }
        // 先反转后续节点head.getNext()
        Node reHead = Reverse1(head.getNext());
        // 将当前结点的指针域指向前一结点
        head.getNext().setNext(head);
        // 前一结点的指针域令为null;
        head.setNext(null);
        // 反转后新链表的头结点
        return reHead;
    }

    /**
     * 单链表翻转
     * 迭代
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
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
     * 单链表输出倒数第k个元素
     * 简单粗暴直接思路：遍历两次，第一次遍历整个列表确定长度n，而倒数第k个即第n-k-1(注意起点为0)个，第二次遍历走n-k-1步即可获得答案。缺点：节点数量较多时，节点从硬盘到物理内存的读写是一个耗时操作。
     * 巧妙的方法：定义两个指针，我们都知道倒数第k个距离最后一个的距离是k-1，所以可以先移动一个指针走k步后，然后两个指针同时移动，那么在快的指针到达结尾时，慢的指针到达的位置正好是倒数第k个。
     * ---------------------
     *
     * @param head
     * @param k
     * @return
     */
    public static Node method(Node head, int k) {
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
        if (p2 == null) {
            System.out.println(head.getData());
        }
        return p2;
    }


    /**
     * 判断单链表是否有环
     * <p>
     * 快慢指针
     *
     * @param head
     * @return
     */
    public static boolean hasLoop(Node head) {
        Node slow = head;
        Node quick = head;
        while (quick != null && quick.getNext() != null) {
            slow = head.getNext();
            quick = head.getNext().getNext();

            if (slow == quick) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断链表是否为回文
     * https://ling_Wassermelone_wei.fun/2018/08/15/%E5%88%A4%E6%96%AD%E4%B8%80%E4%B8%AA%E9%93%BE%E8%A1%A8%E6%98%AF%E5%90%A6%E4%B8%BA%E5%9B%9E%E6%96%87%E7%BB%93%E6%9E%84/https://lingwei.fun/2018/08/15/%E5%88%A4%E6%96%AD%E4%B8%80%E4%B8%AA%E9%93%BE%E8%A1%A8%E6%98%AF%E5%90%A6%E4%B8%BA%E5%9B%9E%E6%96%87%E7%BB%93%E6%9E%84/
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(Node head) {
        if (head == null && head.getNext() == null) {
            return true;
        }

        Node right = head.getNext();
        Node cur = head;
        while (cur.getNext() != null && cur.getNext().getNext() != null) {
            right = right.getNext();
            cur = cur.getNext().getNext();
        }

        Stack<Node> stack = new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.getNext();
        }

        while (!stack.isEmpty()) {
            if (head.getData() != stack.pop().getData()) {
                return false;
            }
            head = head.getNext();
        }
        return true;
    }

    private static boolean plalinDromeLinkedList(Node<Integer> node) {
        //有两种方法可以解决一种是翻转链表进行比较,另外一种是将链表前半部分进行压栈然后进行弹栈与后半部分的节点进行比较
        //所以要使用到一种数据结构就是栈
        Node<Integer> slow = node;
        Node<Integer> fast = node;
        boolean isOdd = true;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.getNext() != null) {
            //快的一次走两步,慢的一次走一步那么最后快的结束了慢的走了一半,此时在走的过程中需要压栈
            stack.push(Integer.valueOf(slow.getData()));
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (fast != null) {
                isOdd = false;
            }
        }
        //假如是奇数慢指针需要再走一步
        if (isOdd) {
            slow = slow.getNext();
        }
        while (!stack.isEmpty()) {
            //出栈
            if (!stack.pop().equals(slow.getData())) {
                return false;
            }
            slow = slow.getNext();
        }
        return true;
    }


    /**
     * 删除链表中指定元素
     *
     * @param head
     * @param val
     * @return
     */
    public static Node removeElements(Node<Integer> head, int val) {
        while (head != null && head.getData() == val) {
            head = head.getNext();
        }
        if (head == null) {
            return null;
        }
        Node<Integer> prev = head;
        while (prev.getNext() != null) {
            if ((Integer) prev.getNext().getData() == val) {
                prev.setNext(prev.getNext().getNext());
            } else {
                prev = prev.getNext();
            }
        }
        return head;
    }


    public static boolean ishui(Node head) {

        if (head == null || head.getNext() != null) {
            return false;
        }
        Node slow = head;
        Node quick = head;

        while (quick.getNext() != null) {
            slow = slow.getNext();
            quick = quick.getNext().getNext();
        }
        Stack<Node> stack = new Stack<>();
        while (slow.getNext() != null) {
            stack.push(slow.getNext());
        }
        Node cur = head;
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(cur)) {
                return false;
            }
            cur = cur.getNext();

        }
        return true;
    }

}

