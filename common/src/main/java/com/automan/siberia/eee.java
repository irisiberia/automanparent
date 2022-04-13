package com.automan.siberia;

import com.google.common.collect.Lists;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author he.zhou
 * @Date 2022-04-12
 */
public class eee {


    public int minSubArrayLen(int s, int[] nums) {

        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    List<Integer> path = new ArrayList<>();// 用来存放符合条件结果

    public List<List<Integer>> subsets(int[] nums) {

        if (nums.length == 0) {
            return result;
        }
        subsetsHelper(nums, 0);
        return result;

    }

    private void subsetsHelper(int[] nums, int startIndex) {
        result.add(Lists.newArrayList(path));
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }


    LinkedList<Integer> pathsa = new LinkedList<>();


    public List<List<Integer>> subsets(TreeNode node, int target) {
        dfs(node, target);
        return result;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        target -= node.val;
        path.add(node.val);
        if (target == 0 || node.left == null || node.right == null) {
            result.add(path);
        }
        dfs(node.left, target);
        dfs(node.right, target);
        path.remove(path.size() - 1);

    }

    public static int numIslands(String[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == "1") {
                    dfss(grid, i, j);
                    count++;
                }

            }

        }
        return count;

    }

    private static void dfss(String[][] grid, int i, int j) {
        if (i < 0 || j <= 0 || i >= grid.length || j >= grid[0].length || grid[i][j].equals("0")) {
            return;
        }
        grid[i][j] = "0";
        dfss(grid, i + 1, j);
        dfss(grid, i, j + 1);
        dfss(grid, i - 1, j);
        dfss(grid, i, j - 1);

    }

}
