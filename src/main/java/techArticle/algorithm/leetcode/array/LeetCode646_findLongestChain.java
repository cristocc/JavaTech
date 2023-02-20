package techArticle.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode646_findLongestChain {

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)-> a[1]- b[1]);
        int ans = 0;
        int cur = Integer.MIN_VALUE;
        for(int[] pair:pairs){
            if(cur < pair[0]){
                cur = pair[1];
                ans++;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int [][] nums = {{1,2},{2,3},{3,4},{1,3}};
        findLongestChain(nums);
    }
}
