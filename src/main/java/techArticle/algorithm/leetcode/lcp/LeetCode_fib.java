package techArticle.algorithm.leetcode.lcp;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_fib {

    public int numWays(int n) {
        int[] dp = new int[n + 1];
        if(n == 0 || n == 1){
            return 1;
        }
       dp[0] = dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}
