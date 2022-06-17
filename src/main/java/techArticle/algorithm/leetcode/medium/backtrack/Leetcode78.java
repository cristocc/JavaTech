package techArticle.algorithm.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
//https://leetcode-cn.com/problems/permutations-ii/
public class Leetcode78 {

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
