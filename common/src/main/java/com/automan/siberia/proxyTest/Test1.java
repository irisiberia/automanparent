package com.automan.siberia.proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author he.zhou
 * @date 2019/12/30
 **/
public class                             Test1 {
    public static void main(String[] args) {
        UserManagerImpl target = new UserManagerImpl();
        UserManager userManager = (UserManager) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args1) -> {
                    System.out.println("kaishi");
                    Object object = method.invoke(target, args1);
                    System.out.println("jieshu");
                    return object;
                });
        userManager.delUser("ss");
    }
}
