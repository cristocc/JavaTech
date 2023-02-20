package techArticle.algorithm.leetcode.lcp;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_findRepeatNumber {


    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer val:nums){
            if(set.contains(val)){
                return val;
            }else {
                set.add(val);
            }
        }
        return 0;

    }
}
