package techArticle.algorithm.leetcode.dp;

/**
 * Created by crist on 2021/4/15
 * https://leetcode.cn/problems/maximum-subarray/
 * @author cc
 */
public class LeetCode53_maxSubArray {

    //nums = [5,4,-1,7,8]
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
        }

        for(int i=0;i<dp.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
