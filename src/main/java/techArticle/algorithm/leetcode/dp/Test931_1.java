package techArticle.algorithm.leetcode.dp;


import java.util.Arrays;

/**
 * Created by crist on 2021/4/15
 *
 * @author cc
 */
public class Test931_1 {

    static int [][] memo ;

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }
        for(int j=0;j<n;j++){
            res = Math.min(res,dp(matrix,n-1,j));
        }
        return res;

    }

    private static int dp(int[][] matrix,int i ,int j){
        if(i<0||j<0 || i>=matrix.length || j>=matrix.length){
            return 9999999;
        }
        if(i==0){
            return matrix[0][j];
        }
        if(memo[i][j] == 66666){
            return memo[i][j];
        }
        memo[i][j] = matrix[i][j] + min(dp(matrix,i-1,j-1),dp(matrix,i-1,j),dp(matrix,i-1,j+1));
        return memo[i][j];
    }

    static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));

    }

}
