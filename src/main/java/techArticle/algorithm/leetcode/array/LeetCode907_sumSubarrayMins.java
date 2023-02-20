package techArticle.algorithm.leetcode.array;

import org.apache.ibatis.annotations.Param;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode907_sumSubarrayMins {

    public int sumSubarrayMins(int[] arr) {

        if(null == arr || arr.length == 0){
            return 0;
        }
        int len = arr.length;
        int ans = 0;
        for(int i=0;i<len;i++){
            int min = arr[i];
            for(int j=i;j<len;j++){
                min = Math.min(min,arr[j]);
                ans+= min;
            }

        }
        return ans;
    }
}
