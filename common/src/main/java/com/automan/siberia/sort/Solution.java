package com.automan.siberia.sort;

import com.automan.siberia.sort.treetest.TreeNode;

/**
 * 二叉树两节点之差最小值
 *
 */
public class Solution {

    int minDiff = Integer.MAX_VALUE;
    TreeNode<Integer> prev = null;

    public void inOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeftChild());
        if (prev != null) {
            minDiff = Math.min(minDiff, root.getData() - prev.getData());
        }
        prev = root;

        inOrder(root.getRightChild());
    }

     //二叉查找树中，中间节点的值一定是其左右节点值的中间数，因此最小差别一定是在中间节点与左右节点之间
     //中序遍历二叉查找树，每次比较当前节点与前一节点差值的绝对值与目前result中保存的最小值的大小，将较小的保存在result中
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }
}
