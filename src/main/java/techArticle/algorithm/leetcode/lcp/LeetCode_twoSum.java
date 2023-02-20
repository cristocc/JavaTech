package techArticle.algorithm.leetcode.lcp;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_twoSum {

    public int[] exchange(int[] nums) {
        int[] ans = new int[nums.length];
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] % 2 != 0){
                ans[index] = nums[i];
                index++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] % 2 == 0){
                ans[index] = nums[i];
                index++;
            }
        }

        return ans;
    }
}
