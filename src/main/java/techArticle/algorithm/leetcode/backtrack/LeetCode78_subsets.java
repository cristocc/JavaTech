package techArticle.algorithm.leetcode.backtrack;

import java.util.*;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/subsets/
 * @author cc
 */
public class LeetCode78_subsets {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        dfs(nums,track,0);
        return ans;
    }


    private void dfs(int[] nums,List<Integer> track,int index){
        ans.add(new ArrayList<>(track));
        for (int j = index; j < nums.length; j++) {
            track.add(nums[j]);
            dfs(nums,track,j+1);
            track.remove(track.size() - 1);
        }
    }
}
