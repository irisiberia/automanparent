package com.automan.siberia.sort.treetest;

/**
 * @Author: he.zhou
 * @Date: 2019-07-19
 */
public class TreeNode<T> {

    private int index;

    /**
     * 数据项
     */
    private T data;

    /**
     * 指向左结点分支
     */
    private TreeNode leftChild;

    /**
     * 指向左结点分支
     */
    private TreeNode rightChild;

    public TreeNode(T data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
