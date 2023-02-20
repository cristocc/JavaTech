package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/3/31
 *https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author cc
 */
public class LeetCode454_fourSumCount {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }

}
