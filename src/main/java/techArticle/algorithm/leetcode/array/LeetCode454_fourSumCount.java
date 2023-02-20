package techArticle.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/3/31
 *https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author cc
 */
public class LeetCode454_fourSumCount {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                int key = - u - v;
                if (countAB.containsKey(key)) {
                    ans += countAB.get(key);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        fourSumCount(nums1,nums2,nums3,nums4);
    }

}
