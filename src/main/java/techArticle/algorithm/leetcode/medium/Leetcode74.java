package techArticle.algorithm.leetcode.medium;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
//https://leetcode-cn.com/problems/search-a-2d-matrix/
public class Leetcode74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0; ) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

}
