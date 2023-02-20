package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/4/30
 * https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/
 * @author cc
 */
public class LeetCode1252_oddCells {

    public int oddCells(int m, int n, int[][] indices) {
        int res =0;
        int [][] matrix = new int[m][n];
        for(int [] index:indices){
            for(int i = 0;i<n;i++){
                matrix[index[0]][i]++;
            }
            for(int i = 0;i<m;i++){
                matrix[i][index[1]]++;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((matrix[i][j] & 1 ) != 0){
                    res++;
                }
            }
        }
        return res;

    }

}
