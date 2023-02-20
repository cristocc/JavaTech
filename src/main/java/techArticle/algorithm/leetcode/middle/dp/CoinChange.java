package techArticle.algorithm.leetcode.middle.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/7/19
 *
 * @author cc
 */
public class CoinChange {
    int[] memo;

    public static int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE-1;
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i],dp[i - coin ] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE-1? -1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        coinChange1(coins,11);
    }

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo,-2);
        return dfs(coins,amount);
    }


    public int dfs(int[] coins, int amount){
        if(amount <0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        if(memo[amount] != -2){
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int coin :coins){
            int sub = dfs(coins,amount - coin);
            if(sub == -1){
                continue;
            }
            min = Math.min(min,sub +1);
        }
        memo[amount] = (min == Integer.MAX_VALUE)?-1:min;
        return memo[amount];

    }

}
