package techArticle.algorithm.leetcode.middle.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.LongFunction;

/**
 * Created by crist on 2022/7/18
 *
 * @author cc
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<nums.length -2;i++){
            int n = nums[i];

            if (n > 0){
                break;
            }
            if( i > 0 && n == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            int target = -n;
            while (left < right){
                int sum = nums[left] + nums[right];
                if(sum == target){
                    ans.add(Arrays.asList(n,nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum < target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        test.threeSum(nums);
    }
}
