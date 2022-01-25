package com.automan.siberia.sort;

import com.alibaba.druid.sql.visitor.functions.Left;
import com.automan.siberia.Node;
import com.automan.siberia.brage.bridgeTset.EmailSendMsg;
import com.automan.siberia.threadPool.pool2.Test;
import org.apache.commons.lang.text.StrTokenizer;
import org.aspectj.weaver.ast.Var;

import javax.xml.stream.events.EndDocument;
import java.util.jar.Attributes;

/**
 * @Author he.zhou
 * @Date 2021-12-23
 */
public class Sort211223 {

    public static void main(String[] args) {
        int i = iSame(new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6}, 6);
        System.out.println();

        int[] ints = {7, 8, 9, 1, 2, 3, 4, 5, 6};
//        System.out.println(iSame(ints, 5));
//        mao(ints);
        test(ints, 0, ints.length - 1);
        System.out.println(ints);
    }

    public static void mao(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }

        }
    }

    public static int getMax333(int[] arr) {
        int max = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {

            max = Math.max(max + arr[i], arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    /**
     * 78912345
     *
     * @param arr
     * @param target
     * @return
     */
    public static int iSame(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                //mid 落在左边
                if (arr[mid] > arr[start]) {
                    if (arr[mid] > target && arr[start] < target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (arr[mid] < target && arr[end] > target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }

                }
            }
        }
        return -1;
    }

    public static void tesssst(int[] arr) {
        int start = 0;
        int high = arr.length - 1;
        while (start < high) {
            while (start < high && arr[high] % 2 == 0) {
                high--;
            }
            while (start < high && arr[start] % 2 != 0) {
                start++;
            }
            int i = arr[high];
            arr[high] = arr[start];
            arr[start] = i;

        }
    }


    private static int[] merge(int[] arr1, int[] arr2) {
        int three = arr1.length + arr2.length;
        int i = 0;
        int j = 0;
        int[] arr3 = new int[three];
        for (int k = 0; k < arr3.length; k++) {


        }
        return arr3;
    }

    public static int getMax(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                end = mid - 1;
            }
        }
        return -1;
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

    public static Node delete(Node head, int k) {
        if (k < 0) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.getNext();
        }
        while (p1 != null) {
            p2 = p2.getNext();
            p1 = p1.getNext();
        }

        p2.setNext(p2.getNext().getNext());
        return head;
    }

    public static boolean isDuiChen(Testiii.TreeNode node) {
        if (node == null) {
            return false;
        }
        return false;
    }

    public static void test(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int temp = arr[low];

        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            while (left < right && arr[left] <= temp) {
                left++;
            }
            if (left < right) {
                int i = arr[right];
                arr[right] = arr[left];
                arr[left] = i;
            }
        }

        arr[low] = arr[left];
        arr[left] = temp;
        test(arr, 0, left - 1);
        test(arr, left + 1, high);
    }


    /**
     * https://blog.csdn.net/weixin_40807247/article/details/91447922
     *
     * @param head
     * @return
     */
    private Node getNode(Node head) {
        Node slow = head;
        Node quick = head;
        while (quick != null && quick.getNext() == null) {
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
}
