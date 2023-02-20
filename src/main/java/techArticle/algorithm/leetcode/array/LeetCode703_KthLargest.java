package techArticle.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by crist on 2021/3/26
 * https://leetcode.cn/problems/kth-largest-element-in-a-stream/
 * @author cc
 */
public class LeetCode703_KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public LeetCode703_KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }

    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        char a = 'a';
        System.out.println((int )a - 'a');
    }
}
