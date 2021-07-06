package com.automan.siberia.chain;

import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

@Service
public class SecondHandler extends Handler {
    @Override
    public String handleRequest(String start) {
        start = start + "b";
        if (getNextHandler() != null) {
            return getNextHandler().handleRequest(start);
        }
        return start;
    }

    public static void main(String[] args) {
        Handler handler = new ConcreteHandler();
        SecondHandler handler1 = new SecondHandler();
        handler.setNextHandler(handler1);
        ThirdHandler handler2=new ThirdHandler();
        handler1.setNextHandler(handler2);

        System.out.println(handler.handleRequest("1"));
    }
}
