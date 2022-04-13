package com.automan.siberia;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

/**
 * @Author he.zhou
 * @Date 2022-03-28
 */
public class Solution1 {
    LinkedList<Integer> path = Lists.newLinkedList();
    LinkedList<LinkedList<Integer>> res = Lists.newLinkedList();

    public LinkedList<LinkedList<Integer>> pathSum(Solution.TreeNode root, int target) {
        rec(root, target);
        return res;
    }

    public void rec(Solution.TreeNode root, int target) {

        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.right == null && root.left == null) {
            res.add(new LinkedList(path));
        }
       rec(root.left,target);
       rec(root.right,target);
       path.removeLast();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TreeNode {
        public Integer val;
        public Solution.TreeNode left;
        public Solution.TreeNode right;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
    }
}
