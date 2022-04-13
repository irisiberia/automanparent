package com.automan.siberia.chain.chain1;

/**
 * @Author he.zhou
 * @Date 2022-03-13
 */
public abstract class AbstractHandler {

    private AbstractHandler nextHandler;

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract String handleRequest(String start);

}
