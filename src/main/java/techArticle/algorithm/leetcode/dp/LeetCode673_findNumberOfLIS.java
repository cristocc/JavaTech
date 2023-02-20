package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/regular-expression-matching/
 * @author cc
 */
public class LeetCode673_findNumberOfLIS {

    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for(int i=1;i<len;i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1]+1;
            }
        }
        int ans = 0;
        for(int v:dp){
            ans = Math.max(ans,v);
        }

        return ans;
    }

    public int findLengthOfLCIS1(int[] nums) {
        int len = nums.length;
        int count = 1;
        int ans = 1;
        for(int i=1;i<len;i++){
            if(nums[i] > nums[i-1]){
                count++;
                ans = Math.max(count,ans);
            }else{
                count = 1;
            }
        }
        return ans;
    }

}
