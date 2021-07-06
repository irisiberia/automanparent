package com.automan.siberia.adapterTset1;

/**
 * @Author: he.zhou
 * @Date: 2018-12-21
 * <p>
 * 适配器模式
 * <p>
 * 一个抽象类可以实现一个接口，那么对于抽象类的子类，
 * 则必须覆写抽象类和接口的全部（未实现的）抽象方法。
 * （即如果接口中的某类方法在抽象类中实现了（覆写了），
 * 那么在抽象类的子类中就可以不用覆写了。因为继承，在父类中的方法，被子类继承了，相当于子类覆写了，子类照样可以调用、覆写该方法。
 */
public interface Window {
    void open();    // 打开

    void close();    // 关闭

    void activated();    // 窗口活动

    void iconified();    // 窗口最小化

    void deiconified();// 窗口恢复大小
}
