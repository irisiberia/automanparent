package com.automan.siberia;

/**
 * @Author: he.zhou
 * @Date: 2018-10-26
 */
public class Node<T>{
    /**
     * 数据域
     */
    private T Data;

    /**
     * 指针域
     */
    private Node Next;

    public Node(T data) {
        Data = data;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node Next) {
        this.Next = Next;
    }
}
