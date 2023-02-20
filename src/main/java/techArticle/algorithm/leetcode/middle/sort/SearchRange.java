package techArticle.algorithm.leetcode.middle.sort;

import java.util.Arrays;

/**
 * Created by crist on 2022/7/19
 *
 * @author cc
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.fill(ans,-1);
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                int i = mid;
                while (i >= 0 && nums[i] == target){
                    i--;
                }
                ans[0] = i;
                i = mid;
                while (i<nums.length && nums[i] == target){
                    i++;
                }
                ans[1] = i-1;
                return ans;

            }else if(nums[mid] > target){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return ans;
    }

}
