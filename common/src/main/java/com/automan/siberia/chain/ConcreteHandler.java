package com.automan.siberia.chain;

import org.springframework.stereotype.Service;

@Service
public class ConcreteHandler extends Handler {

    @Override
    public String handleRequest(String start) {
        start = start + "a";
        return getNextHandler().handleRequest(start);
    }
}
