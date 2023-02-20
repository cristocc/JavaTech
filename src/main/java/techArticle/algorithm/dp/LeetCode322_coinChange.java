package techArticle.algorithm.dp;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/coin-change/
 * @author cc
 */
public class LeetCode322_coinChange {


/*    输入：coins = [1, 2, 5], amount = 11
    输出：3
    解释：11 = 5 + 5 + 1*/

    public int coinChange(int[] coins, int amount) {
        return dp(coins,amount);
    }

    int dp(int[] coins , int amount){
        if(amount == 0){
            return 0;
        }
        if(amount <0){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            int subproblem = dp(coins,amount - coin) ;
            if(subproblem == -1){
                continue;
            }
            res = Math.min(subproblem + 1,res);
        }
        return res;
    }
}
