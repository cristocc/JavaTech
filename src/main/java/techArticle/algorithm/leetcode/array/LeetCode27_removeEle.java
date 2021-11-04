package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/4/19
 *
 * @author cc
 */
public class LeetCode27_removeEle {

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = {4,2,3,4};
        removeElement(nums,3);


    }
}
