package techArticle.algorithm.leetcode.dp;


import java.util.Arrays;

/**
 * Created by crist on 2021/4/15
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 * @author cc
 */
public class Test300 {

/*    输入：nums = [10,9,2,5,3,7,101,18]
    输出：4
    解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。*/

    public int lengthOfLIS(int[] nums) {
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            res = Math.max(res,dp[i]);
        }

        return res;
    }
}
