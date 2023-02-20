package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/3/30
 *
 * @author cc
 */
public class LeetCode643_findMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        int maxSum = sum;
        for(int i = k;i<nums.length;i++){
            sum = sum - nums[i - k] + nums[k];
            maxSum = Math.max(sum,maxSum);
        }
        return 1.0 * maxSum / 4;
    }


}
