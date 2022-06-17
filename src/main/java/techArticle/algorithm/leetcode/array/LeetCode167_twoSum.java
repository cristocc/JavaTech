package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/4/30
 *https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @author cc
 */
public class LeetCode167_twoSum {
    int[] twoSum(int[] nums, int target) {
        // 一左一右两个指针相向而行
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                // 题目要求的索引是从 1 开始的
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++; // 让 sum 大一点
            } else if (sum > target) {
                right--; // 让 sum 小一点
            }
        }
        return new int[]{-1, -1};
    }

}
