package techArticle.algorithm.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/longest-common-subsequence/
 * @author cc
 */
public class LeetCode712_minimumDeleteSum {

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
}
