package com.automan.siberia.reflect;

/**
 * @author he.zhou
 * @date 2019/9/22
 **/
public class MyStudent {

    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public void show() {
        System.out.println("show");
    }
}
