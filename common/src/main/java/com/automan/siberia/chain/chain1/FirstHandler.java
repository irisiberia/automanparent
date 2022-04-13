package com.automan.siberia.chain.chain1;

/**
 * @Author he.zhou
 * @Date 2022-03-13
 */
public class FirstHandler extends AbstractHandler {

    @Override
    public String handleRequest(String start) {
        start = start + 1;
        return getNextHandler().handleRequest(start);
    }

}
