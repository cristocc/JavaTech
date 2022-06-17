package techArticle.algorithm.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
//https://leetcode-cn.com/problems/combination-sum/
public class Leetcode46 {

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
