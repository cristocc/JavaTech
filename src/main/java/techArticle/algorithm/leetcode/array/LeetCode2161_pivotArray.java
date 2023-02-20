package techArticle.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode2161_pivotArray {

    public int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        int[] ans = new int[len];
        int k = 0;
        for(int i = 0;i<len;i++){
            if(nums[i] < pivot){
                ans[k++] = nums[i];
            }
        }
        for(int i = 0;i<len;i++){
            if(nums[i] == pivot){
                ans[k++] = nums[i];
            }
        }
        for(int i = 0;i<len;i++){
            if(nums[i] > pivot){
                ans[k++] = nums[i];
            }
        }
        return ans;

    }
}
