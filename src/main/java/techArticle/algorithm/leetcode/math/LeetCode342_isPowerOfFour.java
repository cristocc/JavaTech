package techArticle.algorithm.leetcode.math;

/**
 * Created by crist on 2021/4/28
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * @author cc
 */
public class LeetCode342_isPowerOfFour {

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

}
