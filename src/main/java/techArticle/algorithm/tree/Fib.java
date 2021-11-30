package techArticle.algorithm.tree;

/**
 * Created by crist on 2021/11/25
 *
 * @author cc
 */
public class Fib {

    private int fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return fib(n-1) + fib(n - 2);
    }



    private int fib1(int n){
        int[] memo = new int[n+1];
        return helper(memo,n);
    }

    private int helper(int[] memo,int n){
        if(n == 0 || n == 1){
            return n;
        }
        if(memo[n] != 0){
            return memo[n];
        }
        return helper(memo,n-1) + helper(memo,n-2);
    }

    private int fib2(int n){
        int[] memo = new int[n+1];
        memo[0] = 0;memo[1] = 1;
        for(int i=2 ;i<= n;i++){
            memo[i] = memo[i-1]+memo[i-2];
        }
        return memo[n];
    }

    int coinChange(int[] coins, int amount) {
        // 题目要求的最终结果是 dp(amount)
        //coins = {1,2,5},amount 11
        return dp(coins, amount);
    }

    int dp(int[] coins, int amount) {
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
            if (subProblem == -1){
                continue;
            }
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
