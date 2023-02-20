package techArticle.algorithm.leetcode.dp;

/**
 * Created by crist on 2022/6/9
 * https://leetcode.cn/problems/video-stitching/
 * @author cc
 */
public class LeetCode62_uniquePaths {

    int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        LeetCode62_uniquePaths test = new LeetCode62_uniquePaths();
        test.jump(nums);

    }

}
