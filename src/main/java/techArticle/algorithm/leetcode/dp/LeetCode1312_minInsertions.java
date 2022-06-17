package techArticle.algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * @author cc
 */
public class LeetCode1312_minInsertions {

    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int span = 2; span <= n; span++) {
            for (int i = 0; i <= n - span; i++) {
                int j = i + span - 1;
                System.out.print("i:"+i + ",j:"+j +" ,");
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1]) +1;
                }
            }
            System.out.println();
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        LeetCode1312_minInsertions test = new LeetCode1312_minInsertions();
        System.out.println(test.minInsertions("mbadm"));

    }

}
