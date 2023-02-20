package techArticle.algorithm.leetcode.middle.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/7/19
 *
 * @author cc
 */
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for(int d:dp){
            ans = Math.max(d,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }


}
