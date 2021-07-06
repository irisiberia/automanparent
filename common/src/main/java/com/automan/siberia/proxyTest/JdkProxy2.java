package com.automan.siberia.proxyTest;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy2 {


    public static void main(String[] args) {

        UserManager newProxyInstance = (UserManager) Proxy.newProxyInstance(
                UserManagerImpl.class.getClassLoader(),
                new Class[]{UserManager.class},

                new InvocationHandler() {
                    //invoke 代表的是执行代理对象的方法
                    @Override
                    //method：代表目标对象的方法字节码对象
                    //args:代表目标对象的响应的方法的参数
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // TODO Auto-generated method stub
                        System.out.println("JDK代理=====开始");
                        Object invoke = method.invoke(new UserManagerImpl(), args);
                        System.out.println("JDK代理=====结束");
                        return invoke;
                    }
                });
        newProxyInstance.addUser("2", "2");
        newProxyInstance.delUser("33");
//        UserManagerImpl target = new UserManagerImpl();
//        UserManager newProxyInstance1 = (UserManager) Proxy.newProxyInstance(
//                target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        //反射知识点
//                        Object invoke = method.invoke(target, args);
//                        return invoke;
//                    }
//                });
//
//
//
//        newProxyInstance1.addUser("2", "2");
    }
}
