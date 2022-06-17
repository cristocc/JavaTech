package techArticle.algorithm.leetcode.dp;


import java.util.Arrays;

/**
 * Created by crist on 2021/4/15
 *
 * @author cc
 */
public class Test322 {

    int[] meno;

    public  int coinChange(int[] coins, int amount) {
        meno = new int[amount+1];
        Arrays.fill(meno,-666);
        return dp(coins,amount);
    }

    public int dp(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        if(amount < 0 ){
            return -1;
        }
        if(meno[amount] != -666){
            return meno[amount];
        }
        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            int sub = dp(coins,amount-coin);
            if(sub == -1){
                continue;
            }
            res = Math.max(res,sub+1);
        }
        meno[amount] = res;
        return meno[amount];
    }



}
