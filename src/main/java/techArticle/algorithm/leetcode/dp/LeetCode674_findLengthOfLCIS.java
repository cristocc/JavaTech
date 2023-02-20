package techArticle.algorithm.leetcode.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/regular-expression-matching/
 * @author cc
 */
public class LeetCode674_findLengthOfLCIS {



    public static int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int[] count = new int[len];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int maxLength = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        int res = 0;
        for(int i = 0; i < len; i++){
            if(dp[i] == maxLength){
                res += count[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        findNumberOfLIS(nums);
    }



}
