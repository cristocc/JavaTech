package techArticle.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode216_combinationSum3 {

    public static int[] twoSum1(int[] nums, int target) {
        Arrays.sort(nums);
        int[] ret = {0,0};
        if(nums.length <= 1){
            return ret;
        }
        int head = 0;
        int tail = nums.length - 1;
        while(head <= tail){
            int a = nums[head];
            int b = nums[tail];
            if(a + b> target){
                tail--;
            }else if(a +b <target){
                head++;
            }else{
                ret[0] = head;
                ret[1] = tail;
                break ;
            }
        }
        return ret;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ret = {0,0};
        if(nums.length <= 1){
            return ret;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] ret = twoSum(nums,target);
        System.out.println(Arrays.stream(ret));
    }
}
