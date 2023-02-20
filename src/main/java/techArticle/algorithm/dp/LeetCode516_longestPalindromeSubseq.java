package techArticle.algorithm.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/longest-common-subsequence/
 * @author cc
 */
public class LeetCode516_longestPalindromeSubseq {

/*    输入: s1 = "sea", s2 = "eat"
    输出: 231
    解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
    在 "eat" 中删除 "t" 并将 116 加入总和。
    结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。*/

   int [][] memo ;

    public int longestPalindromeSubseq(String s) {

    }

    int dp(String s1, int i, String s2, int j){

        return memo[i][j];
    }
}
