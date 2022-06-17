package techArticle.algorithm.leetcode.dp;

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

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int l = dp(word1,0,word2,0);
        return m+n-2 * l;
    }

    int dp(String s1,int m, String s2,int n){
        if(m == s1.length() || n == s2.length()){
            return 0;
        }
        if(s1.charAt(m) == s2.charAt(n)){
            return dp(s1, m+1,  s2, n+1) + 1;
        }
        return Math.max(dp(s1, m+1,  s2, n) ,dp(s1, m,  s2, n+1) );
    }



}
