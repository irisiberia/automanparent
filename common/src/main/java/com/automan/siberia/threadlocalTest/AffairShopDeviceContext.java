package com.automan.siberia.threadlocalTest;

public class AffairShopDeviceContext {

    private final static ThreadLocal<String> DEVICE_LOCAL = new ThreadLocal();
    private static String string;

    public static String getString() {
        return string;
    }

    public static void setString(String string) {
        AffairShopDeviceContext.string = string;
    }

    public AffairShopDeviceContext() {

    }

    public static void setDeviceLocal(String shopDeviceAo) {
        DEVICE_LOCAL.set(shopDeviceAo);
    }


    public static String getDeviceLocal() {
        return DEVICE_LOCAL.get();
    }

    public static void release() {
        DEVICE_LOCAL.remove();
    }


    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            AffairShopDeviceContext.setDeviceLocal(Thread.currentThread().getName());
            AffairShopDeviceContext.setString("232");
            AffairShopDeviceContext context=new AffairShopDeviceContext();
        }).start();
        new Thread(() -> {
            System.out.println(AffairShopDeviceContext.getDeviceLocal()+"==="+AffairShopDeviceContext.getString());

        }).start();
        new Thread(() -> {
            System.out.println(AffairShopDeviceContext.getDeviceLocal()+"==="+AffairShopDeviceContext.getString());
        }).start();

        Thread.sleep(1000);
    }
}
