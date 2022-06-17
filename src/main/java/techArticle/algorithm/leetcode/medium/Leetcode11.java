package techArticle.algorithm.leetcode.medium;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
//https://leetcode-cn.com/problems/container-with-most-water/
public class Leetcode11 {

    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int area = Math.min(height[left] , height[right]) * (right - left );
            res = Math.max(area,res);
            if(height[left] <= height[right]){
                left ++;
            }else{
                right--;
            }
        }
        return res;
    }

}
