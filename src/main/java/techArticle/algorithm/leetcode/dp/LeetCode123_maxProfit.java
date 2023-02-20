package techArticle.algorithm.leetcode.dp;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 * @author cc
 */
public class LeetCode123_maxProfit {

/*    dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
    dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
            = max(dp[i-1][1][1], -prices[i])
    解释：k = 0 的 base case，所以 dp[i-1][0][0] = 0。

    现在发现 k 都是 1，不会改变，即 k 对状态转移已经没有影响了。
    可以进行进一步化简去掉所有 k：
    dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    dp[i][1] = max(dp[i-1][1], -prices[i])*/
        public int maxProfit(int[] prices) {
            int max_k = 2, n = prices.length;
            int[][][] dp = new int[n][max_k + 1][2];
            for (int i = 0; i < n; i++) {
                for (int k = max_k; k >= 1; k--) {
                    if (i - 1 == -1) {
                        // 处理 base case
                        dp[i][k][0] = 0;
                        dp[i][k][1] = -prices[i];
                        continue;
                    }
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
                }
            }
            // 穷举了 n × max_k × 2 个状态，正确。
            return dp[n - 1][max_k][0];
        }

}
