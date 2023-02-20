package techArticle.algorithm.leetcode.lcp;

import techArticle.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_exchange {

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int val = nums[left] + nums[right];
            if(val == target){
                ans[0] = nums[left];
                ans[1] = nums[right];
                break;
            }else if(val > target){
                right -- ;
            }else {
                left ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        twoSum(nums,9);

    }
}
