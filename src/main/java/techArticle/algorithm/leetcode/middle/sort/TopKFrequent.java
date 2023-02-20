package techArticle.algorithm.leetcode.middle.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by crist on 2022/7/19
 *
 * @author cc
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        //先统计每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        //最大堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet())
            priorityQueue.add(new int[]{key, map.get(key)});

        //取堆中最大的k个元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = priorityQueue.poll()[0];
        return res;
    }


}
