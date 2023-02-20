package techArticle.algorithm.leetcode.middle.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by crist on 2022/7/19
 *
 * @author cc
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];//在查找

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
