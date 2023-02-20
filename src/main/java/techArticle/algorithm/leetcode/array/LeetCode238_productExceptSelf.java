package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/4/30
 *
 * @author cc
 */
public class LeetCode238_productExceptSelf {

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }
}
