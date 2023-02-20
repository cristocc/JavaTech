package techArticle.algorithm.leetcode.math;

/**
 * Created by crist on 2021/4/28
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * @author cc
 */
public class LeetCode69_mySqrt {

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode69_mySqrt test = new LeetCode69_mySqrt();
        test.mySqrt(2);
    }

}
