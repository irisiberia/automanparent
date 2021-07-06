package com.automan.siberia.chain;

/**
 * 责任链模式
 */
public abstract class Handler {

    private Handler nextHandler;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    //处理方法
    public abstract String handleRequest(String start);
}
