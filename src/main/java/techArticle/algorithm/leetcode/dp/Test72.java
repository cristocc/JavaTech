package techArticle.algorithm.leetcode.dp;


import java.util.Arrays;

/**
 * Created by crist on 2021/4/15
 * https://leetcode.cn/problems/edit-distance/
 * @author cc
 */
public class Test72 {

    // 备忘录
    int[][] memo;

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(word1,m-1,word2,n-1);
    }

    int dp(String s1, int i, String s2, int j) {
        if(i==-1){
            return j+1;
        }
        if(j==-1){
            return i+1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = dp(s1,i-1,s2,j-1);
        }else{
            memo[i][j] = min(dp(s1,i-1,s2,j)+1,dp(s1,i-1,s2,j-1) +1,dp(s1,i,s2,j-1)+1);
        }
        return memo[i][j];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
