package techArticle.algorithm.leetcode.lc.dp;

/**
 * Created by crist on 2022/7/27
 *
 * @author cc
 */
public class MaxSubArray {

/*    输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。*/


    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1;i<len;i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
        }
        for(int i = 0;i<len;i++){
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSubArray test = new MaxSubArray();
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        test.maxSubArray(nums);
    }
}
