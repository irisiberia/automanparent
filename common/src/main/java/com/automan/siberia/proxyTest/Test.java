package com.automan.siberia.proxyTest;

import com.automan.siberia.proxyCglibTest.InvocationHandler;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: he.zhou
 * @Date: 2019-07-12
 */
public class Test implements InvocationHandler {
    @Override
    public void invoke(Object o, Method m) {
        HashMap map=new HashMap<>();
        map.put("23","323");
    }
}
