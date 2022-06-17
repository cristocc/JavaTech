package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/longest-palindromic-subsequence/
 * @author cc
 */
public class LeetCode516_longestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // 备忘录，初始化为 -1
        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // 整个 s 的最长回文子序列长度
        return dp(s, 0, n - 1);
    }

    // 备忘录
    int[][] memo;

    // dp 函数的定义是：在子串 s[i..j] 中，最长回文子序列的长度为 dp(s, i, j)。
    int dp(String s, int i, int j) {
        int n = s.length();
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        // 查备忘录，防止重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 状态转移方程
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = dp(s, i + 1, j - 1) + 1;
        } else {
            memo[i][j] = Math.max(dp(s, i + 1, j), dp(s, i, j - 1)
            );
        }
        return memo[i][j];
    }

}
