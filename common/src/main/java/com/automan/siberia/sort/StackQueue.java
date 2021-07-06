package com.automan.siberia.sort;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.automan.bean.Test;
import com.google.common.collect.Lists;
import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: he.zhou
 * @Date: 2019-08-15
 */
public class StackQueue {

    private static final Stack<Integer> stack1 = new Stack<Integer>();

    private static final Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);
    }

    /**
     * 两个栈实现队列
     *
     * @return
     */
    public static int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());

            }

        }
        return stack2.pop();
    }


    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.get(2);
        ArrayList list33 = new ArrayList();
        list33.get(3);

        JSONArray array = new JSONArray();
        array.add(Lists.newArrayList("2", "3", "3", "3"));
        array.add("ewew");
        array.add(3);


        JSONObject object = new JSONObject();
        object.put("bbb", array);

        System.out.println(object.toJSONString());
        JSONArray array1 = object.getJSONArray("bbb");
        List<String> list = (List<String>) array1.get(0);
        System.out.println(list);


        push(2);
        push(3);
        push(4);

        System.out.println(pop());
    }

}
