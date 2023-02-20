package techArticle.algorithm.leetcode.array;

import java.util.*;

/**
 * Created by crist on 2021/3/31
 *
 * @author cc
 */
public class LeetCode228_summaryRanges {


    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int length = nums.length;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<length-1;i++){
            int diff = nums[i+1] - nums[i];
            if(diff == 1){
                if(sb.length() == 0){
                    sb.append(nums[i]).append("->");
                }
            }else{
                sb.append(nums[i]);
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if(sb.length() == 0){
            result.add(nums[length - 1] + "");
        }else{
            sb.append(nums[length - 1]);
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        LeetCode228_summaryRanges test = new LeetCode228_summaryRanges();
        test.summaryRanges(nums);
    }
}
