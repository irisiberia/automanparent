package com.automan.siberia.mianshi2021;

import com.automan.ArrTest;
import com.automan.siberia.Node;
import com.automan.siberia.sort.treetest.TreeNode;
import org.springframework.util.StringUtils;

import javax.imageio.ImageReader;
import java.util.Stack;
import java.util.jar.JarEntry;

/**
 * @Author he.zhou
 * @Date 2022-03-13
 */
public class rrr {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    private void push(int ss) {

    }

    private int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public static boolean validPalindrome1(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void maopao(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean bo = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    bo = false;
                }
            }
            if (bo) {
                break;
            }
        }
    }


    public static int erfen(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < 10; ++i) {
            System.out.println(i);
        }


        int[] arr = new int[]{1, 2, 3, 4, 5, 9, 8, 7};
        int[] arr1 = new int[]{7, 8, 9, 1, 2, 3, 5};
        System.out.println(getMax(arr));
        System.out.println(fanzhuan(arr1, 1));
        boolean b = validPalindrome1("123431");
        System.out.println(b);
        Node<Integer> integerNode = new Node<Integer>(1);
        Node<Integer> sds = new Node<Integer>(2);
        integerNode.setNext(sds);
        Node<Integer> sd = new Node<Integer>(3);

        Node node = delete111(integerNode, 1);
        System.out.println();

    }

    public static Node delete111(Node head, int k) {
        if (k < 0) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        int count = 0;
        while (p1.getNext() != null) {
            count++;
            if (count <= k) {
                p1.setNext(p1.getNext());
            } else {
                p1.setNext(p1.getNext());
                p2.setNext(p2.getNext());
            }
        }

        if (head.getNext() == null || count + 1 == k) {
            head = head.getNext();
        } else {
            p1.setNext(p1.getNext().getNext());
        }
        return head;


    }

    //    12345987
    public static int getMax(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if (arr[mid] < arr[mid] + 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int max = 0;

    public int getMax1(TreeNode<Integer> node) {
        getMax(node);
        return max;
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = max + Math.max(0, prices[i] + prices[i - 1]);

        }
        return max;

    }


    public boolean IsPalindrome1(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;

        }
        return true;


    }


    public int getMax(TreeNode<Integer> node) {

        if (node == null) {
            return 0;
        }
        int left = getMax(node.getLeftChild());
        int right = getMax(node.getRightChild());

        max = Math.max(left + right + node.getData(), max);
        return Math.max(Math.max(left, right) + node.getData(), 0);

    }

    public int FindGreatestSumOfSubArray(int[] arr) {
        int max = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max + arr[i], arr[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    // 7891235
    public static int fanzhuan(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                //判断落在左区间
                if (arr[mid] > arr[end]) {
                    if (arr[start] <= target && arr[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (arr[mid] < target && arr[end] >= target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void tets11(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            while (arr[end] % 2 == 0) {
                end--;
            }
            while (arr[start] % 2 != 0) {
                start++;
            }
            if (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
    }


    public boolean tessst(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return tessst(node1.getRightChild(), node2.getRightChild()) &&
                tessst(node1.getLeftChild(), node2.getLeftChild());

    }

    public static void tets11(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int start = left;
        int end = right;
        int temp = arr[left];
        while (start < end) {
            while (start < end && arr[end] >= temp) {
                end--;
            }
            while (start < end && arr[end] <= temp) {
                start++;
            }
            if (start < end) {
                int st = arr[start];
                arr[start] = arr[end];
                arr[end] = st;
            }
        }
        arr[left] = arr[start];
        arr[start] = temp;

        tets11(arr, left, start - 1);
        tets11(arr, start + 1, right);
    }

    public Node fanzhuan(Node head) {
        Node now = head;
        Node prev = null;
        while (now != null) {
            Node next = now.getNext();
            now.setNext(prev);
            prev = now;
            now = next;
        }
        return prev;
    }


    public Node hasLoop(Node head) {
        Node quick = head;
        Node slow = head;
        while (quick != null && quick.getNext() != null) {
            quick = quick.getNext().getNext();
            slow = slow.getNext();
            if (quick == slow) {
                break;
            }
        }

        quick = head;
        while (quick != slow) {
            quick = quick.getNext();
            slow = slow.getNext();
        }
        return quick;

    }

    public boolean hloop(Node head) {

        Node slow = head;
        Node quick = head;
        while (quick != null && quick.getNext() != null) {
            quick = quick.getNext();
            slow = slow.getNext();
        }

        Stack<Node> stack = new Stack<Node>();

        while (slow != null) {
            slow = slow.getNext();
            stack.push(slow);
        }

        while (!stack.empty()) {
            boolean equals = stack.pop().equals(head);
            if (!equals) {
                return false;
            }
            head = head.getNext();
        }

        return true;
    }

    public Node delete(Node head, int k) {
        Node slow = head;
        Node quick = head;
        for (int i = 0; i < k; i++) {
            quick = quick.getNext();
        }
        while (quick != null) {
            slow = slow.getNext();
            quick = quick.getNext();
        }
        slow.setNext(slow.getNext().getNext());
        return head;
    }

    public Node hebsssing(Node head) {

        Node prev = null;
        Node now = head;
        while (now != null) {
            Node next = now.getNext();
            now.setNext(prev);
            prev = now;
            now = next;
        }
        return prev;
    }


    public Node hebing(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node head;
        if ((int) head1.getData() < (int) head2.getData()) {
            head = head1;
            head.setNext(hebing(head1.getNext(), head2));
        } else if ((int) head1.getData() > (int) head2.getData()) {
            head = head2;
            head.setNext(hebing(head1, head2.getNext()));
        } else {
            head = head1;
            head.setNext(hebing(head1.getNext(), head2.getNext()));
        }

        return head;
    }


    public Boolean xiangdeng(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.getData() != node2.getData()) {

            return false;
        }
        return xiangdeng(node1.getLeftChild(), node2.getLeftChild()) &&
                xiangdeng(node1.getRightChild(), node2.getRightChild());

    }


    public Boolean duichen(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return duichen(node1.getLeftChild(), node2.getRightChild())
                && duichen(node1.getRightChild(), node2.getLeftChild());
    }

    static int max1 = 0;


    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.getLeftChild());
        int right = dfs(root.getRightChild());
        max1 = Math.max(max1, (Integer) root.getLeftChild().getData() + left + right);
        return Math.max(Math.max(left, right) + (Integer) root.getData(), 0);
    }


}
