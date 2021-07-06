package com.automan.mywork;

/**
 * @author he.zhou
 * @date 2020/1/14
 **/
public class Singtol {

    private Singtol() {
    }

    public static class inner {
        private static final Singtol singtol = new Singtol();
    }

    public static Singtol getSing() {
        return inner.singtol;
    }
}
