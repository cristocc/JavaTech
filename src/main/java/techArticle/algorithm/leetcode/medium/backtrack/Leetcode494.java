package techArticle.algorithm.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
//https://leetcode-cn.com/problems/restore-ip-addresses/
public class Leetcode494 {

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,0,0);
        return count;
    }

    private void dfs(int[] nums,int target,int index,int sum){
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            dfs(nums, target, index + 1, sum + nums[index]);
            dfs(nums, target, index + 1, sum - nums[index]);
        }
    }

}
