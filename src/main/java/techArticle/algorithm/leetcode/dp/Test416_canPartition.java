package techArticle.algorithm.leetcode.dp;

/**
 * Created by crist on 2021/4/15
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 * @author cc
 */
public class Test416_canPartition {

    //给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
/*
    输入：nums = [1,5,11,5]
    输出：true
    解释：数组可以分割成 [1, 5, 5] 和 [11] 。
*/

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum %2 != 0){
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        boolean [][] dp = new boolean[n+ 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(j - nums[i-1] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Test416_canPartition test = new Test416_canPartition();
        test.canPartition(nums);
    }
}
