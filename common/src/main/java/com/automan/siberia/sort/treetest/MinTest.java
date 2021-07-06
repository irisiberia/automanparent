package com.automan.siberia.sort.treetest;

import java.util.Stack;

public class MinTest {

    static Stack<Integer> sk= new Stack();
    public int getMinimumDifference(TreeNode<Integer> root) {
        MidSearch(root);
        int ans=Integer.MAX_VALUE;
        int prev=sk.pop();
        while(!sk.isEmpty()){
            int cur=sk.pop();
            ans=ans>(prev-cur)?(prev-cur):ans;
            prev=cur;
        }
        return ans;
    }
    public void MidSearch(TreeNode<Integer> root) {
        if(root==null)
            return;
        MidSearch(root.getLeftChild());
        sk.push(root.getData());
        MidSearch(root.getRightChild());
    }

}
