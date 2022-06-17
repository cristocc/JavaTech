package techArticle.algorithm.leetcode.dp;


import java.util.Arrays;

/**
 * Created by crist on 2021/4/15
 *
 * @author cc
 */
public class Test931 {

    static int [][] meno ;

    public static int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        meno = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(meno[i], 66666);
        }
        for(int j = 0;j<n;j++){
            res = Math.min(res,dp(matrix,n-1,j));
        }
        return res;
    }

    private static int dp(int[][] matrix,int i ,int j){
        if(i < 0 || j<0 || i>= matrix.length || j>=matrix[0].length){
            return 99999;
        }
        if(i == 0){
            return matrix[0][j];
        }
        if(meno[i][j] != 66666){
            return meno[i][j];
        }
        meno[i][j] = matrix[i][j] + min(dp(matrix,i-1,j-1),dp(matrix,i-1,j),dp(matrix,i-1,j+1));
        return meno[i][j];
    }

    static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        //int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        //System.out.println(minFallingPathSum(matrix));

        System.out.println(longestPalindromeSubseq("abcddcbz"));
    }

    static int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp 数组全部初始化为 0
        int[][] dp = new int[n][n];
        // base case
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;
        // 反着遍历保证正确的状态转移
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        // 整个 s 的最长回文子串长度
        return dp[0][n - 1];
    }


}
