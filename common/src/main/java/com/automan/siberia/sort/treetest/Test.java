package com.automan.siberia.sort.treetest;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: he.zhou
 * @Date: 2019-07-19
 */
public class Test {

    private static ExecutorService executorService = Executors.newFixedThreadPool(4);
    //树节点生成总值
    private static int count1 = 0;
    //树节点计算值
    private static volatile AtomicInteger counts = new AtomicInteger(0);

    private static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static List<TreeNode> nodeList = new LinkedList<TreeNode>();



    /**
     * 遍历线程
     */
    static class CountSubNode implements Callable<Integer> {
        private TreeNode<Integer> node;

        public CountSubNode(TreeNode node) {
            this.node = node;
        }

        @Override
        public Integer call() {
            int deep = 1;
            do {
                //左节点不为空创建新线程计算
                if (node.getLeftChild() != null) {
                    executorService.submit(new CountSubNode(node.getLeftChild()));
                }
                System.out.println("add:" + node.getData());
                //叠加当前节点
                counts.addAndGet(node.getData());
                //重置node
                node = node.getRightChild();
            } while (node.getLeftChild() != null || node != null);
            return null;
        }
    }

    public static void createBinTree() {
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new TreeNode(array[nodeIndex]));
        }

        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).setLeftChild(nodeList.get(parentIndex * 2 + 1));
            // 右孩子
            nodeList.get(parentIndex).setRightChild(nodeList.get(parentIndex * 2 + 2));
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).setRightChild(nodeList
                .get(lastParentIndex * 2 + 1));

        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).setRightChild(nodeList
                    .get(lastParentIndex * 2 + 2));
        }
    }

    /**
     * 先序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrderTraverse(node.getLeftChild());
        postOrderTraverse(node.getRightChild());

    }

    /**
     * 中序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public static void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.getLeftChild());
        System.out.print(node.getData() + " ");
        inOrderTraverse(node.getRightChild());
    }

    /**
     * 后序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public static void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.getLeftChild());
        postOrderTraverse(node.getRightChild());
        System.out.print(node.getData() + " ");
    }

    /**
     * 广度优先遍历
     * <p>
     * 先往队列中插入左节点，再插右节点，这样出队就是先左节点后右节点了。
     * 　　广度优先遍历树，需要用到队列（Queue）来存储节点对象,队列的特点就是先进先出。例如，上面这颗树的访问如下：
     * <p>
     * 　　首先将A节点插入队列中，队列中有元素（A）;
     * <p>
     * 　　将A节点弹出，同时将A节点的左、右节点依次插入队列，B在队首，C在队尾，（B，C），此时得到A节点；
     * <p>
     * 　　继续弹出队首元素，即弹出B，并将B的左、右节点插入队列，C在队首，E在队尾（C,D，E），此时得到B节点；
     * <p>
     * 　　继续弹出，即弹出C，并将C节点的左、中、右节点依次插入队列，（D,E,F,G,H），此时得到C节点；
     * <p>
     * 　　将D弹出，此时D没有子节点，队列中元素为（E,F,G,H），得到D节点；
     *
     * @param root
     */
    public static void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.getData() + "  ");
            if (node.getLeftChild() != null) {
                queue.offer(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                queue.offer(node.getRightChild());
            }
        }
    }

    /**
     * 深度优先遍历
     * <p>
     * 先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
     * 首先将A节点压入栈中，stack（A）;
     * <p>
     * 将A节点弹出，同时将A的子节点C，B压入栈中，此时B在栈的顶部，stack(B,C)；
     * <p>
     * 将B节点弹出，同时将B的子节点E，D压入栈中，此时D在栈的顶部，stack（D,E,C）；
     * <p>
     * 将D节点弹出，没有子节点压入,此时E在栈的顶部，stack（E，C）；
     * <p>
     * 将E节点弹出，同时将E的子节点I压入，stack（I,C）；
     *
     * @param root
     */
    public static void depthOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.getData() + " ");
            if (node.getRightChild() != null) {
                stack.push(node.getRightChild());
            }
            if (node.getLeftChild() != null) {
                stack.push(node.getLeftChild());
            }
        }
    }

    public static void main(String[] args) {
        createBinTree();
        // nodeList中第0个索引处的值即为根节点
        TreeNode root = nodeList.get(0);


        executorService.submit(new CountSubNode(root));
        try {
            Thread.sleep(1000);
            System.out.println("count1={}" + count1);
            System.out.println("counts={}" + counts);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        System.out.println("先序遍历：");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraverse(root);
        System.out.println();

        System.out.println("广度优先遍历:");
        levelTraverse(root);
        System.out.println();

        System.out.println("深度优先遍历:");
        depthOrderTraverse(root);
        System.out.println();
    }


    public static int Fibonacci(int i) {

        if (i == 0) {
            return 1;
        }
        return +Fibonacci(i - 1);
    }

    /**
     * 合并两个二叉树
     * 重叠部分就相加
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode<Integer> mergeTrees(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null && t2 != null) {
            return t2;
        }
        if (t1 != null && t2 == null) {
            return t1;
        }
        t1.setLeftChild(mergeTrees(t1.getLeftChild(), t2.getRightChild()));
        t1.setRightChild(mergeTrees(t1.getRightChild(), t2.getRightChild()));
        if (t1 != null) {
            t1.setData(t1.getData() + t2.getData());
            return t1;
        }
        return t1;
    }

    /**
     * 判断两个二叉树是否相等
     */
    public boolean isSame(TreeNode<Integer> node1, TreeNode<Integer> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 != null && node2 != null) {
            if (node1.getData() != node2.getData()) {
                return false;
            }
            return isSame(node1.getLeftChild(), node2.getLeftChild())
                    && isSame(node1.getRightChild(), node2.getRightChild()
            );
        }
        return false;
    }


    /**
     * 判断二叉树是否对称
     *
     * @param node
     * @return
     */
    boolean isSymmetrical(TreeNode<Integer> node) {
        if (node == null) {
            return false;
        }
        return isSymmetrical(node.getLeftChild(), node.getRightChild());
    }

    private boolean isSymmetrical(TreeNode<Integer> left, TreeNode<Integer> right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.getData() == right.getData()) {
            return isSymmetrical((TreeNode<Integer>) left.getLeftChild(), (TreeNode<Integer>) right.getRightChild()) &&
                    isSymmetrical((TreeNode<Integer>) left.getRightChild(), (TreeNode<Integer>) right.getLeftChild());
        }
        return false;
    }


}
