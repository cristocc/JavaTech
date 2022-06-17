package techArticle.algorithm.leetcode.dp;


import java.util.Arrays;

/**
 * Created by crist on 2021/4/15
 * https://leetcode.cn/problems/maximum-subarray/
 * @author cc
 */
public class Test53 {


/*    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出：6
    解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。*/

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            res= Math.max(res,dp[i]);
        }
        return res;
    }

}
