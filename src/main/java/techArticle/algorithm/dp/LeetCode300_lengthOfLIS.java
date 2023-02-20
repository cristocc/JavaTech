package techArticle.algorithm.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 * @author cc
 */
public class LeetCode300_lengthOfLIS {


/*    输入：nums = [10,9,2,5,3,7,101,18]
    输出：4
    解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。*/
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int [] dp = new int[length];
        int res = 0;
        Arrays.fill(dp,1);
        for(int i=0;i<length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        for(int a:dp){
            res = Math.max(a,res);
        }
        return res;
    }

}
