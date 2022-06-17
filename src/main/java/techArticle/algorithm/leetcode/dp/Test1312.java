package techArticle.algorithm.leetcode.dp;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * @author cc
 */
public class Test1312 {

    //mbadm
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int span = 2; span <= n; span++) {
            for (int i = 0; i <= n - span; i++) {
                int j = i + span -1;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1]) + 1;
                }
            }
        }
        return dp[0][n-1];
    }



}
