package com.automan.siberia.sort;

public class LinkNodeTest {
    //双向链表头结点
    private static LinkNode head = null;
    //双向链表尾结点
    private static LinkNode tail = null;

    public static LinkNode Convert(LinkNode root) {
        if (root == null) {
            return null;
        }
        Convert(root.getLeft());
        if (head == null) {
            head = root;
            tail = root;
        } else {
            root.setLeft(tail);
            tail.setRight(root);
            tail = root;
        }
        Convert(root.getRight());
        return head;
    }
}

