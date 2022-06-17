package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/4/19
 *https://leetcode-cn.com/problems/move-zeroes/
 * @author cc
 */
public class LeetCode283_moveZeroes {

    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
