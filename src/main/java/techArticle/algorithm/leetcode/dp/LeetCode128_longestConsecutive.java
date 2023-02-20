package techArticle.algorithm.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/video-stitching/
 * @author cc
 */
public class LeetCode128_longestConsecutive {

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            if(nums[i] - nums[i-1] == 1){
                dp[i] = Math.max(dp[i-1] + 1,dp[i]);
            }

            if(nums[i] - nums[i-1] == 0){
                dp[i] = dp[i-1] ;
            }
        }

        int result = Integer.MIN_VALUE;
        for(int num:dp){
            result = Math.max(result,num);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,0,1};
        LeetCode128_longestConsecutive test = new LeetCode128_longestConsecutive();
        test.longestConsecutive(a);
    }

}
