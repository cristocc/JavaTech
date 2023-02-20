package techArticle.algorithm.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/longest-common-subsequence/
 * @author cc
 */
public class LeetCode1312_minInsertions {

/*    输入：s = "bbbab"
    输出：4
    解释：一个可能的最长回文子序列为 "bbbb" 。*/

    public int minInsertions(String s) {
        int m = s.length();
        memo = new int[m][m];
        for(int[] row :memo){
            Arrays.fill(row,-1);
        }
        return dp(s,0,m-1);
    }

    int [][] memo ;

    int dp(String s, int i, int j){
        int n = s.length();
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            memo[i][j] = dp(s,i+1,j-1);
        }else{
            memo[i][j] = Math.min(dp(s,i+1,j),dp(s,i,j-1)) + 1;
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        LeetCode1312_minInsertions test = new LeetCode1312_minInsertions();
        int res = test.minInsertions("leetcode");
        System.out.println(res);
        //mbadm
        //mbdadbm

    }

    public int minInsertions1(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int span = 2; span <= n; span++) {
            for (int i = 0; i <= n - span; i++) {
                int j = i + span - 1;
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1]) +1;
                }
            }
        }
        return dp[0][n-1];
    }
}
