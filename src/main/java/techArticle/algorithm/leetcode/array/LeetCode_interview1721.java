package techArticle.algorithm.leetcode.array;

/**
 * Created by crist on 2021/4/2
 *https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 * @author cc
 */
public class LeetCode_interview1721 {

   private static int[] height ={0,1,0,2,1,0,1,3,2,1,2,1};

    public static int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        trap(height);
    }
}
