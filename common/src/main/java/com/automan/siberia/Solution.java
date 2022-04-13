package com.automan.siberia;

import com.automan.siberia.pruduceComsumer.numberThread.Number;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.collect.Lists;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.crypto.Mac;
import javax.swing.text.rtf.RTFEditorKit;
import java.time.Year;
import java.util.*;

/**
 * @Author he.zhou
 * @Date 2022-03-28
 */
public class Solution {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        rec(root, target);
        return res;
    }

    public void rec(TreeNode root, int target) {
        //base case
        if (root == null) return;
        //不管符不符合题意，我们先添加进path中，后续在判断
        path.add(root.val);
        //减去当前节点的值
        target -= root.val;
        //判断是否走到叶子节点位置，并且判断走过的路径是否符合题意。
        if (target == 0 && root.left == null && root.right == null) {
            //符合题意，我们直接吧当前走过的路径放入结果集中
            res.add(new LinkedList(path));
        }
        //不符合题意，又可能是没有走到叶子节点，我们先往左右走
        rec(root.left, target);
        rec(root.right, target);
        //把不符合题意的叶子节点直接移除。
        path.removeLast();
    }


    public static class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;
    }


    public int lengthOfLISsss(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);

        }
        return res;


    }


    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);

        }
        return res;

    }

    public int lengthOfLISss(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0;
            int j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if (res == j) {
                res++;
            }
        }
        return res;
    }

    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }


    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;


        }
        return -1;
    }


    //数组最长递增子序列
    public int lengthOfS1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);

        }
        return max;


    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[tail--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[tail--] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[tail--] = nums1[p1--];
            } else {
                nums1[tail--] = nums2[p2--];
            }
        }

    }

    public void merge12(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int p1 = low;
        int p2 = high;
        int temp = nums[low];
        while (p1 < p2) {
            while (p1 < p2 && nums[p2] >= temp) {
                p2--;
            }

            while (p1 < p2 && nums[p1] <= temp) {
                p1++;
            }
            if (p1 < p2) {
                int num = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = num;
            }
        }

        nums[low] = nums[p1];
        nums[p1] = temp;
        merge12(nums, 0, p1 - 1);
        merge12(nums, p1 + 1, high);
    }


    public int getMax(int[] nums) {
        int max = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i] + max, nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }


    public int getMa111x(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);

        }
        return res;
    }


    public int getMa111sssx(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int num = nums[i];
            nums[i] = nums[num];
            nums[num] = num;
        }
        return -1;
    }

    List<List<Integer>> lo = Lists.newArrayList();
    List<Integer> lo1 = Lists.newArrayList();

    public List<List<Integer>> getMa111sssxssss(TreeNode treeNode, int target) {
        res(treeNode, target);
        return lo;
    }

    private void res(TreeNode treeNode, int target) {
        if (treeNode == null) {
            return;
        }
        target -= treeNode.val;
        lo1.add(treeNode.val);
        if (target == 0 || treeNode.left == null || treeNode.right == null) {
            lo.add(Lists.newArrayList(lo1));
        }
        res(treeNode.left, target);
        res(treeNode.right, target);
        lo.remove(lo.size() - 1);
    }

    int ss = 0;

    private int resss(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = resss(treeNode.left);
        int right = resss(treeNode.right);
        ss = Math.max(ss, treeNode.val + left + right);
        return Math.max(Math.max(left, right) + treeNode.val, 0);

    }

    public int findRepeatNumbersss(int[] nums) {
        int i = 0;
        while (!(nums.length <= i)) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }

    public int[] merges(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[tail--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[tail--] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[tail--] = nums1[p1--];
            } else {
                nums1[tail--] = nums2[p1--];
            }
        }
        return nums1;
    }

    public void merssges(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 < p2) {
            while (nums[p2] % 2 == 0) {
                p2--;
            }
            while (nums[p1] % 2 != 0) {
                p1++;
            }
            int temp = nums[p2];
            nums[p2] = nums[p1];

            nums[p1] = temp;
        }
    }

    public static int getMasssx(int[] arr) {
        int p1 = 0;
        int p2 = arr.length - 1;
        while (p1 <= p2) {
            int mid = (p1 + p2) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                p1 = mid + 1;
            } else {
                p2 = mid - 1;
            }
        }
        return -1;
    }

    List<List<Integer>> lists = Lists.newArrayList();
    List<Integer> patsssh = Lists.newArrayList();

    public void getMasssx(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        target -= node.val;
        patsssh.add(node.val);
        if (target == 0 || node.left == null || node.right == null) {
            lists.add(path);
        }
        getMasssx(node.left, target);
        getMasssx(node.left, target);
        patsssh.remove(patsssh.size() - 1);
    }

    int maxs = 0;

    public int getMasssx(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getMasssx(node.left);
        int right = getMasssx(node.right);

        maxs = Math.max(node.val + left + right, maxs);
        return Math.max(node.val + Math.max(left, right), 0);
    }


    public int findRepeatNumber(int[] nums) {
        int p = 0;
        while (p < nums.length) {
            if (nums[p] == p) {
                p++;
                continue;
            }

            if (nums[p] == nums[nums[p]]) {
                return nums[p];
            }
            int num = nums[p];
            nums[p] = nums[nums[p]];
            nums[nums[p]] = num;
        }
        return -1;
    }

    public int lengtssshOfS(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
                max = Math.max(max, res[i]);

            }

        }
        return max;


    }

    public static class Log {
        public int userid;
        public int login_time;
        public int logout_time;

    }

    public int lenddgtssshOfS(List<Log> logList) {
        int[] logout = new int[86400];
        int max_online = 0;
        int current_online = 0;


        for (int i = 0; i < logList.size(); i++) {
            current_online = current_online - logout[logList.get(i).login_time];

            if (++current_online > max_online) {
                max_online = current_online;
            }
            logout[logList.get(i).logout_time]++;
        }
        return 0;
    }


    public int[] mersassge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;


        while (p1 >= 0 || p2 >= 0) {
            if (p1 == 0) {
                nums1[tail--] = nums2[p2--];
            } else if (p2 == 0) {
                nums1[tail--] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[tail--] = nums1[p1--];
            } else {
                nums1[tail--] = nums2[p2--];
            }
        }
        return nums1;


    }

    public int sdsd(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = sdsd(node.left);
        int right = sdsd(node.right);

        return Math.max(left, right) + 1;


    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {

            max = Math.max(prices[i] - prices[i - 1], 0);

        }
        return max;
    }

    public static void main(String[] args) {
        String[][] grid = new String[][]{
                {"1", "1", "0", "0", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "1", "0", "0"},
                {"0", "0", "0", "1", "1"}


        };
        int i = numIslands(grid);
        System.out.println(i);
    }

    public static int numIslands(String[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].equals("1")) {
                    dfs(grid, i, j);
                    count++;
                }

            }

        }
        return count;

    }








    private static void dfs(String[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j].equals("0")) {
            return;
        }
        grid[i][j] = "0";
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);

    }

    public int maxProfita(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxProfita(node.left);
        int right = maxProfita(node.right);
        return Math.max(left, right) + 1;

    }


}
