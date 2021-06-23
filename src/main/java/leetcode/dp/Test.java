package leetcode.dp;

/**
 * Created by crist on 2021/4/16
 *
 * @author cc
 */
public class Test {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length-1;i++){
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[dp.length-1];
    }

    public int rob1(int[] nums) {
        //[2,7,9,3,1]
        int first = nums[0];
        int sencod = Math.max(first,nums[1]);
        for(int i=2;i<nums.length-1;i++){
            int temp = sencod;
            sencod = Math.max(first+ nums[i],sencod);
            first = temp;
        }

        return sencod;
    }
}
