package com.automan.siberia.sort;

public class LinkNode {
    private int data;
    private LinkNode left;
    private LinkNode right;

    public LinkNode(int i) {
        data = i;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkNode getLeft() {
        return left;
    }

    public void setLeft(LinkNode left) {
        this.left = left;
    }

    public LinkNode getRight() {
        return right;
    }

    public void setRight(LinkNode right) {
        this.right = right;
    }
}
