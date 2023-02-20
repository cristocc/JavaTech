package techArticle.algorithm.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/russian-doll-envelopes/
 * @author cc
 */
public class LeetCode354_maxEnvelopes {


/*    输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
    输出：3
    解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。*/

    public int maxEnvelopes(int[][] envelopes) {
        int n= envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0]? b[1] - a[1]:a[0] - b[0];
            }
        });

        int [] heights = new int[n];
        for(int i=0;i<n;i++){
            heights[i] = envelopes[i][1];
        }
        return lengthOfLIS(heights);
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int [] dp = new int[length];
        int res = 0;
        Arrays.fill(dp,1);
        for(int i=0;i<length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        for(int a:dp){
            res = Math.max(a,res);
        }
        return res;
    }

}
