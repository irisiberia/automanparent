package com.automan.siberia.sort.arrTest;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: he.zhou
 * @Date: 2019-07-12
 */
public class TopK {

    /**
     * 借助 哈希表 来建立数字和其出现次数的映射，遍历一遍数组统计元素的频率
     * 维护一个元素数目为 k 的最小堆
     * 每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
     * 如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
     * 最终，堆中的 k 个元素即为前 k 个高频元素
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //遍历map，用最小堆保存频率最大的k个元素
        //实际上是一个堆（不指定Comparator时默认为最小堆），通过传入自定义的Comparator函数可以实现大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        // 取出最小堆中的元素
        List<Integer> res = Lists.newArrayList();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }


    /**
     * 基于桶排序求解「前 K 个高频元素」
     */
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = Lists.newArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            if (list[map.get(key)] != null) {
                list[map.get(key)].add(key);
            } else {
                list[map.get(key)] = Lists.newArrayList(key);
            }
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for (int i = list.length-1; i >= 0 && res.size()< k; i--) {
            if (list[i] == null) {
                continue;
            }
            res.addAll(list[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 3, 5, 5};
        System.out.println(JSONObject.toJSON(topKFrequent(arr, 3)));
        System.out.println(JSONObject.toJSON(topKFrequent2(arr, 3)));
    }
}
