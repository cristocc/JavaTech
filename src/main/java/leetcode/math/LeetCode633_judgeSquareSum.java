package leetcode.math;

/**
 * Created by crist on 2021/4/28
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * @author cc
 */
public class LeetCode633_judgeSquareSum {

    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum1(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
