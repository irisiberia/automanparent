package com.automan.siberia.chain.chain1;

/**
 * @Author he.zhou
 * @Date 2022-03-13
 */
public class SecindHandler extends AbstractHandler {
    @Override
    public String handleRequest(String start) {
        start = start + 1;
        return null;
    }
}
