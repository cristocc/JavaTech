package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/
 * @author cc
 */
public class LeetCode712_minimumDeleteSum {


    int[][] memo;

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];
        for(int[] row:memo){
            Arrays.fill(row, -1);
        }
        return dp(s1, 0, s2, 0);
    }

    int dp(String s1, int i, String s2, int j) {
        int res = 0;
        if(i == s1.length()){
            for (; j < s2.length(); j++)
                res += s2.charAt(j);
            return res;

        }
        if(j == s2.length()){
            for (; i < s1.length(); i++)
                res += s1.charAt(i);
            return res;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = Math.min(
                    s1.charAt(i) + dp(s1, i + 1, s2, j),
                    s2.charAt(j) + dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }



}
