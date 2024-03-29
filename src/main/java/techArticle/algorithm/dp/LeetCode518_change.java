package techArticle.algorithm.dp;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/coin-change-2/
 * @author cc
 */
public class LeetCode518_change {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j = 1;j<=amount;j++){
                if(j - coins[i - 1] < 0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }


}
