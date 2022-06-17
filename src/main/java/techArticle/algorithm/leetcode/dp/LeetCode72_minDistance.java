package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 * @author cc
 */
public class LeetCode72_minDistance {

    int[][] memo;

    int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        memo = new int[m][n];
        dp(s1, m - 1, s2, n - 1);
        // i，j 初始化指向最后一个索引
        return memo[m-1][n-1];
    }

    // 定义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
    int dp(String s1, int i, String s2, int j) {
        // base case
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        // 查备忘录，避免重叠子问题
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i - 1, s2, j - 1);
        }else{
            memo[i][j] =  min(
                    dp(s1, i, s2, j - 1) + 1,
                    dp(s1, i - 1, s2, j) + 1,
                    dp(s1, i - 1, s2, j - 1) + 1
            );
        }
        return memo[i][j];
    }

    int minDistance1(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 定义：s1[0..i] 和 s2[0..j] 的最小编辑距离是 dp[i+1][j+1]
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;
        // 自底向上求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        // 储存着整个 s1 和 s2 的最小编辑距离
        return dp[m][n];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        LeetCode72_minDistance test = new LeetCode72_minDistance();
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(test.minDistance1(s1,s2));
    }

}
