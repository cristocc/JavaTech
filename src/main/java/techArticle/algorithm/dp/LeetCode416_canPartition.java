package techArticle.algorithm.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 * @author cc
 */
public class LeetCode416_canPartition {

/*    输入：nums = [1,5,11,5]
    输出：true
    解释：数组可以分割成 [1, 5, 5] 和 [11] 。*/

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n:nums){
            sum += n;
        }
        if(sum % 2!=0){
            return false;
        }
        sum = sum / 2;
        int length = nums.length;
        boolean [][] dp = new boolean[length + 1][sum + 1];
        for (int i = 0; i <= length; i++)
            dp[i][0] = true;

        for(int i = 1; i <= length; i++){
            for(int j = 1;j<=sum;j++){
                if(j - nums[i - 1] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[length][sum];
    }
}
