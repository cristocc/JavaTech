package techArticle.algorithm.leetcode.middle.dp;

/**
 * Created by crist on 2022/7/19
 *
 * @author cc
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        if(nums.length == 0){
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            dp[i] = Math.max(nums[i],dp[i-1] - 1);
            if(dp[i] + i +1>=nums.length){
                return true;
            }else if(dp[i] == 0){
                return false;
            }
        }
        return false;

    }


}
