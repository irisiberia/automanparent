package com.automan.siberia.sort.treetest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CpuTree {

    //线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(4);
    //树节点生成总值
    private static int count1 = 0;
    //树节点计算值
    private static volatile AtomicInteger counts = new AtomicInteger(0);

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0); // 以数组第一个元素为根节点
        // 创建/存储二叉树
        CpuTree.createTree(root);
        //开启线程遍历
        bianli(root);
           try {
            Thread.sleep(1000);
            System.out.println("count1={}" + count1);
            System.out.println("counts={}" + counts);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public static void bianli(TreeNode node) {
        while (node != null && node.left != null) {
            TreeNode finalNode = node;
            System.out.println(node.val);
            executorService.execute(() ->  bianli(finalNode.left));
            node = finalNode.right;
        }
    }


    static class TreeNode {
        //节点值
        int val;
        // 左节点
        TreeNode left;
        // 右节点
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 创建二叉树
     *
     * @param node
     * @return
     */
    public static void createTree(TreeNode node) {
//        if(count1>30)
//            return;
        int num = (int) (Math.random() * 100);
        if (num < 50) {
            count1 += num;
            node.left = new TreeNode(num);
            createTree(node.left);
        }
        num = (int) (Math.random() * 100);
        if (num < 50) {
            count1 += num;
            node.right = new TreeNode(num);
            createTree(node.right);
        }
    }

}
