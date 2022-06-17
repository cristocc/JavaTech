package techArticle.algorithm.leetcode.dp;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by crist on 2022/6/14
 * https://labuladong.github.io/algo/3/25/79/
 * @author cc
 */
public class KnapsackTest {
/*    给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
    其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？*/
/*    N = 3, W = 4
    wt = [2, 1, 3]
    val = [4, 2, 3]*/
//dp[i][w] 表示：对于前 i 个物品（从 1 开始计数），当前背包的容量为 w 时，这种情况下可以装下的最大价值是 dp[i][w]。

    int knapsack(int W, int N, int[] wt, int[] val) {
        int [][] dp = new int[N+1][W+1];
        for(int i = 1;i<=N;i++){
            for(int w=1;w<=W;w++){
                if(w-wt[i-1] < 0){
                    dp[i][w] = dp[i-1][w];
                }else{
                    dp[i][w] = Math.max(dp[i-1][w],dp[i-1][w-wt[i-1]] + val[i]);
                }
            }
        }
        return dp[N][W];
    }

}
