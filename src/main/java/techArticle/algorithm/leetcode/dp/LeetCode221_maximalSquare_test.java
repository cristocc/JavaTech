package techArticle.algorithm.leetcode.dp;

/**
 * Created by crist on 2021/4/16
 *
 * @author cc
 */
public class LeetCode221_maximalSquare_test {

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int i = 0;i<rows;i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
            }
        }
        for(int i = 0;i<cols;i++){
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;
            }
        }
        for(int i=1 ;i<rows;i++ ){
            for(int j = 1;j<cols;j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;

    }
}
