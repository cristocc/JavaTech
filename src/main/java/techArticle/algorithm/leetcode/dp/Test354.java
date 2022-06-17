package techArticle.algorithm.leetcode.dp;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by crist on 2021/4/15
 * https://leetcode.cn/problems/russian-doll-envelopes/
 * @author cc
 */
public class Test354 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0]? b[1]-a[1]: a[0]-b[0];
            }
        });
        int[] nums = new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            nums[i] = envelopes[i][1];
        }

       return lengthOfLIS(nums);
    }


    public static int lengthOfLIS(int[] nums) {
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
