package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 *  https://leetcode.cn/problems/house-robber/
 * @author cc
 */
public class LeetCode198_rob {

    private int[] memo;
    // 主函数
    public int rob(int[] nums) {
        // 初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        // 强盗从第 0 间房子开始抢劫
        return dp(nums, 0);
    }

    // 返回 dp[start..] 能抢到的最大值
    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        // 避免重复计算
        if (memo[start] != -1){
            return memo[start];
        }
        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        // 记入备忘录
        memo[start] = res;
        return res;
    }

    int rob1(int[] nums) {
        int n = nums.length;
        // dp[i] = x 表示：
        // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
        // base case: dp[n] = 0
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }
}
