package techArticle.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/4/19
 *
 * @author cc
 */
public class LeetCode442 {

    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        findDuplicates(nums);

    }
}
