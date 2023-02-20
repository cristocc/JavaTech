package techArticle.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode560_subarraySum {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int start = 0;start<nums.length;start++){
            int sum = 0;
            for(int end = start;end>=0;end--){
                sum += nums[end];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}
