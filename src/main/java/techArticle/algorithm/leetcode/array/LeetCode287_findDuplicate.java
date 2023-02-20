package techArticle.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * Created by crist on 2021/4/30
 *https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @author cc
 */
public class LeetCode287_findDuplicate {

// 1,2,2,3,4
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1;
        int r = nums.length - 1;
        int ans = -1;
        while(l < r){
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

}
