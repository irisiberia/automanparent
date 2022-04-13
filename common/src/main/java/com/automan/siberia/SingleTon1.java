package com.automan.siberia;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author he.zhou
 * @Date 2022-03-11
 */
public class SingleTon1 {

    private static volatile SingleTon1 singleTon1;


    private SingleTon1() {
    }

    public static SingleTon1 getSingleTon1() {
        if (singleTon1 == null) {
            synchronized (SingleTon1.class) {
                if (singleTon1 == null) {
                    singleTon1 = new SingleTon1();
                }
            }
        }
        return singleTon1;
    }

    public static int f(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }


//    private SingleTon1() {
//    }
//
//
//    private static class inner {
//        public static SingleTon1 singleTon1 = new SingleTon1();
//    }
//
//    public static SingleTon1 getInstance() {
//        return inner.singleTon1;
//    }



    //存放结果
    List<List<Integer>> res = new ArrayList<>();
    //存放当前路径
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    //start表示这次遍历从哪里开始
    public void dfs(int[] nums, int start){
        //树之中的每个节点都要保存，所以我们一上来就直接添加到结果。
        res.add(new ArrayList<>(path));
        //从上一层的节点之后（start）开始遍历到结尾
        for (int i = start; i < nums.length; i++){
            //添加到当前路径
            path.add(nums[i]);
            //从下一个节点开始，递归下一层
            dfs(nums, i + 1);
            //回溯
            path.remove(path.size() - 1);
        }
    }

}
