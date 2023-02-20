package techArticle.algorithm.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/longest-common-subsequence/
 * @author cc
 */
public class LeetCode712_minimumDeleteSum {

/*    输入: s1 = "sea", s2 = "eat"
    输出: 231
    解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
    在 "eat" 中删除 "t" 并将 116 加入总和。
    结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。*/

   int [][] memo ;


    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];
        for(int [] row:memo){
            Arrays.fill(row,-1);
        }
        return dp(s1,0,s2,0);
    }

    int dp(String s1, int i, String s2, int j){
        int res = 0;
        if(i == s1.length()){
            for(;j<s2.length();j++){
                res += s2.charAt(j);
            }
        }
        if(j == s2.length()){
            for(;i<s1.length();i++){
                res += s1.charAt(i);
            }
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = dp( s1,i + 1,  s2,j+1);
        }else{
            memo[i][j] = Math.min(s1.charAt(i) + dp(s1, i + 1, s2, j), s2.charAt(j) + dp(s1, i, s2, j + 1));
        }
        return memo[i][j];
    }
}
