package techArticle.algorithm.leetcode.dp;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/video-stitching/
 * @author cc
 */
public class LeetCode279 {

    public  static int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                System.out.print("i:"+i+",j:"+j + " ");
                int temp = f[i - j * j];
                min = Math.min(min, temp);
            }
            System.out.println();
            f[i] = min + 1;
        }
        return f[n];
    }


    public static void main(String[] args) {
        numSquares(9);

    }

}
