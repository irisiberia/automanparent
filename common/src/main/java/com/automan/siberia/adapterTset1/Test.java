package com.automan.siberia.adapterTset1;

/**
 * @Author: he.zhou
 * @Date: 2018-12-21
 */
public class Test {
    public static void main(String[] args) {
        WindowAdapter adapter = new WindowImpl();
        adapter.open();
        adapter.close();
        adapter.iconified();
        System.out.println("==============");
        WindowAdapter adapter2 = new Window2Impl();
        adapter2.open();
        adapter2.close();
        adapter2.iconified();
    }
}
