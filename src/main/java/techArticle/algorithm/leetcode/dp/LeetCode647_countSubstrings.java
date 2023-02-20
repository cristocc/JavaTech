package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/dungeon-game/
 * @author cc
 */
public class LeetCode647_countSubstrings {

    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = 0;

        for (int j = 0; j < n; j++) { // 注意扫描矩阵的方向，下面会解释
            for (int i = 0; i <= j; i++) {
                //System.out.print("i="+i+" j="+j + " ");
                if (i == j) {   // 单个字符的情况
                    dp[i][j] = true;
                    result++;
                } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) { // 两个字符的情况
                    dp[i][j] = true;
                    result++;
                } else if (j - i > 1 && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) { // 多于两个字符
                    dp[i][j] = true;
                    result++;
                }
            }
            //System.out.println();
        }

        return result;
    }

    public static void main(String[] args) {
        countSubstrings("abc");
    }
}
