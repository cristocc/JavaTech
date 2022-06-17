package techArticle.algorithm.labuladong;

import java.util.Arrays;

/**
 * Created by crist on 2022/3/4
 *
 * @author cc
 */
public class Test {

/*    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }*/

    public static void main(String[] args) {
       int[] coins = {1, 2, 3};
       int amount = 6;
       //coinChange(coins,amount);
    }

     int [] memo;
    public  int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo,-666);
        return dp(coins,amount);
    }

    private  int dp(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        if(memo[amount] != -666){
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            int sub = dp(coins,amount - coin);
            if(sub == -1){
                continue;
            }
            res = Math.min(res,sub+1);
        }
        memo[amount] = res;
        return memo[amount];
    }

}
