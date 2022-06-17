package techArticle.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/permutations/
 * @author cc
 */
public class LeetCode46_permute {
    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        dfs(track,nums);
        return res;
    }

    void dfs(List<Integer> track,int[] nums){
        if(track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!track.contains(nums[i])){
                track.add(nums[i]);
                dfs(track,nums);
                track.remove(track.size()-1);
            }
        }

    }
}
