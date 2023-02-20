package techArticle.algorithm.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/longest-common-subsequence/
 * @author cc
 */
public class LeetCode1143_longestCommonSubsequence {

/*    输入：text1 = "abcde", text2 = "ace"
    输出：3
    解释：最长公共子序列是 "ace" ，它的长度为 3 。*/

   int [][] memo ;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        memo = new int[m][n];
        for(int [] row:memo ){
            Arrays.fill(row,-1);
        }
        return dp(text1,0,text2,0);
    }

    int dp(String s1, int i, String s2, int j){
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = dp(s1,i+1,s2,j+1) + 1;
        }else{
            memo[i][j] = Math.max(dp(s1,i+1,s2,j),dp(s1,i,s2,j+1));
        }
        return memo[i][j];
    }

    public int longestCommonSubsequence1(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        s1 = " " + s1; s2 = " " + s2;
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int[][] f = new int[n + 1][m + 1];

        // 因为有了追加的空格，我们有了显然的初始化值（以下两种初始化方式均可）
        // for (int i = 0; i <= n; i++) Arrays.fill(f[i], 1);
        for (int i = 0; i <= n; i++) f[i][0] = 1;
        for (int j = 0; j <= m; j++) f[0][j] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (cs1[i] == cs2[j]) {
                    f[i][j] = f[i -1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        // 减去最开始追加的空格
        return f[n][m] - 1;
    }
}
