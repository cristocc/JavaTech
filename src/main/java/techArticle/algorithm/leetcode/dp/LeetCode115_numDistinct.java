package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/minimum-path-sum/
 * @author cc
 */
public class LeetCode115_numDistinct {

    int[][] memo;

    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        memo = new int[slen][tlen];
        for(int[] m:memo){
            Arrays.fill(m,-1);
        }
        return dfs(s,t,slen - 1,tlen - 1);
    }


    public int dfs(String s, String t,int i,int j){
        if(j < 0){
            return 1;
        }
        if(i < 0 ){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            memo[i][j] = dfs(s,t,i-1,j) + dfs(s,t,i-1,j-1);
        }else {
            memo[i][j] = dfs(s,t,i-1,j);
        }
        return memo[i][j];
    }

    public int numDistinct1(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int [][] dp = new int[slen+1][tlen+1];
        for (int j = 0; j < s.length() + 1; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i < slen + 1; i++) {
            for (int j = 1; j < tlen + 1; j++) {
                if (t.charAt(j - 1) == s.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[slen][tlen];
    }

    public static void main(String[] args) {
        LeetCode115_numDistinct test = new LeetCode115_numDistinct();
        int a = test.numDistinct1("rabbbit","rabbit");
        System.out.println(a);
    }
}
