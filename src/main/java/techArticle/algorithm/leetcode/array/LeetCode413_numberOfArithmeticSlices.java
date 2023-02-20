package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/3/31
 *https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author cc
 */
public class LeetCode413_numberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        if(n == 1){
            return ans;
        }
        int d = nums[0] - nums[1];
        int t = 0;
        for(int i = 2;i<n;i++){
            if(nums[i-1] - nums[i] == d){
                t++;
            }else{
                d = nums[i-1] - nums[i];
                t = 0;
            }
            ans += t;
        }

        return ans;

    }

}
