package techArticle.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/12/29
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * @author cc
 */
public class Leetcode303_NumArray {
    // 前缀和数组
    private int[] preSum;

    /* 输入一个数组，构造前缀和 */
    public Leetcode303_NumArray(int[] nums) {
        // preSum[0] = 0，便于计算累加和
        preSum = new int[nums.length + 1];
        // 计算 nums 的累加和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    /* 查询闭区间 [left, right] 的累加和 */
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

}
