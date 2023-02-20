package techArticle.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode162_findPeakElement {

    public int findPeakElement(int[] nums) {
        int index = 0;
        int length = nums.length;
        for(int i=0;i< length - 1 ;i++){
            if(nums[i] > nums[i+1]){
                index = i;
                break;
            }
        }
        if(length == 1){
            return index;
        }

        if(nums.length >1 && index ==0 && nums[length -2] < nums[length-1]){
            return length - 1;
        }
        return index;
    }

    public static void main(String[] args) {
        int [] nums = {1,2};
        LeetCode162_findPeakElement test = new LeetCode162_findPeakElement();
        System.out.println(test.findPeakElement(nums));
    }
}
