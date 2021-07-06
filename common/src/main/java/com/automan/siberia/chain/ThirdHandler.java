package com.automan.siberia.chain;

import org.springframework.stereotype.Service;

/**
 * @author he.zhou
 * @date 2019/11/18
 **/
@Service
public class ThirdHandler extends Handler {
    @Override
    public String handleRequest(String start) {
        start = "Third" + start;
        if (getNextHandler() != null) {
            return  getNextHandler().handleRequest(start);
        }
        return start;
    }
}
