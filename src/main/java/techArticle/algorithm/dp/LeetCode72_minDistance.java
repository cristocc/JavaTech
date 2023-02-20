package techArticle.algorithm.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/edit-distance/
 * @author cc
 */
public class LeetCode72_minDistance {

/*    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出：6
    解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。*/

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int [] dp = new int[length];
        int res = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for(int i = 1;i<length;i++){
            dp[i] = Math.max(nums[i],nums[i] + dp[i-1]);
        }
        for(int d : dp){
            res = Math.max(res,d);
        }
        return res;
    }

}
