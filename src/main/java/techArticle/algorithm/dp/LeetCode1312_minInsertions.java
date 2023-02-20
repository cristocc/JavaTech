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

   int [][] memo ;

    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        memo = new int[m][m];
        for(int[] row :memo){
            Arrays.fill(row,-1);
        }
        return dp(s,0,m-1);
    }

    int dp(String s, int i, int j){
        int n = s.length();
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            memo[i][j] = dp(s,i+1,j-1) + 1;
        }else{
            memo[i][j] = Math.max(dp(s,i+1,j),dp(s,i,j-1));
        }
        return memo[i][j];
    }
}
