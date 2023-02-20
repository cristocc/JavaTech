package techArticle.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode594_findLHS {

    public int findLHS(int[] nums) {
        Map<Integer,Integer> cnt = new HashMap<>();
        for(Integer num:nums){
            cnt.put(num,cnt.getOrDefault(num,0)+1);
        }

        int max = Integer.MIN_VALUE;
        for(Integer key:cnt.keySet()){
            int key_1 = key + 1;
            if(cnt.containsKey(key_1)){
                max = Math.max(max,cnt.get(key) + cnt.get(key_1));
            }
        }

        return max;
    }
}
