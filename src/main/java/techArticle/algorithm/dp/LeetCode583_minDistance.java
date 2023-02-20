package techArticle.algorithm.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/delete-operation-for-two-strings/
 * @author cc
 */
public class LeetCode583_minDistance {

/*    输入: word1 = "sea", word2 = "eat"
    输出: 2
    解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"*/


   int [][] memo ;

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // 复用前文计算 lcs 长度的函数
        int lcs = longestCommonSubsequence(word1, word2);
        return m - lcs + n - lcs;
    }

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
