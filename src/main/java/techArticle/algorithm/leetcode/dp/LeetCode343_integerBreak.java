package techArticle.algorithm.leetcode.dp;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/gas-station/
 * @author cc
 */
public class LeetCode343_integerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                System.out.print("i:"+i+",j:"+j+",i-j:"+i+"-"+j+" ");
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            System.out.println();
            dp[i] = curMax;
        }
        return dp[n];
    }

    public static void main(String[] args) {

        LeetCode343_integerBreak test = new LeetCode343_integerBreak();
        test.integerBreak(5);

    }

}
