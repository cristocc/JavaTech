package techArticle.algorithm.labuladong;

import java.util.Arrays;

/**
 * Created by crist on 2021/11/5
 *
 * @author cc
 */
public class DPTest {

    static class coinchage{
        static int coinChange(int[] coins, int amount) {
            // 题目要求的最终结果是 dp(amount)
            return dp(coins, amount);
        }
        static int dp(int[] coins, int amount) {
            // base case
            if (amount == 0){
                return 0;
            }
            if (amount < 0){
                return -1;
            }
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 计算子问题的结果
                int subProblem = dp(coins, amount - coin);
                // 子问题无解则跳过
                if (subProblem == -1) continue;
                // 在子问题中选择最优解，然后加一
                res = Math.min(res, subProblem + 1);
            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

    static class coinchage1{
        static int coinChange1(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            // 数组大小为 amount + 1，初始值也为 amount + 1
            Arrays.fill(dp, amount + 1);
            // base case
            dp[0] = 0;
            // 外层 for 循环在遍历所有状态的所有取值
            for (int i = 0; i < dp.length; i++) {
                // 内层 for 循环在求所有选择的最小值
                for (int coin : coins) {
                    // 子问题无解，跳过
                    if (i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return (dp[amount] == amount + 1) ? -1 : dp[amount];
        }
    }

    static class coinchage2{
        int[] memo;
        int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            // dp 数组全都初始化为特殊值
            Arrays.fill(memo, -666);
            return dp(coins, amount);
        }
        int dp(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            // 查备忘录，防止重复计算
            if (memo[amount] != -666)
                return memo[amount];
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 计算子问题的结果
                int subProblem = dp(coins, amount - coin);
                // 子问题无解则跳过
                if (subProblem == -1) continue;
                // 在子问题中选择最优解，然后加一
                res = Math.min(res, subProblem + 1);
            }
            // 把计算结果存入备忘录
            memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
            return memo[amount];
        }
    }

    static class fib{
        static int fib(int N) {
            // 备忘录全初始化为 0
            int[] memo = new int[N + 1];
            // 进行带备忘录的递归
            return helper(memo, N);
        }
        static int helper(int[] memo, int n) {
            // base case
            if (n == 0 || n == 1){
                return n;
            }
            // 已经计算过，不用再计算了
            if (memo[n] != 0){
                return memo[n];
            }
            memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
            return memo[n];
        }
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        //coinChange1(coins,6);
        fib.fib(5);
    }
}
