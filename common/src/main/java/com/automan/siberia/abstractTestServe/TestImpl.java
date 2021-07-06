package com.automan.siberia.abstractTestServe;

/**
 * @Author: he.zhou
 * @Date: 2018-12-24
 */
public class TestImpl extends AbstractTest {

    private String ss;
    private String aa;

    public TestImpl(String ss, String aa) {
        this.ss = ss;
        this.aa = aa;
    }

    @Override
    public void start() {
        if (aa.equals(ss)) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object end() {
        return "我是子类0.0.0";
    }


    public int step(int a, int b) {
        return 9999;
    }


    public String error() {
        System.out.println(super.error());
        return "发生错误2222";
    }

    public void myOwn() {
        System.out.println(step(1, 3));
    }


}
