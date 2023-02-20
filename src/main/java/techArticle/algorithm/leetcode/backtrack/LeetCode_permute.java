package techArticle.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/combination-sum/
 * @author cc
 */
public class LeetCode_permute {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> track = new ArrayList<>();
        dfs(candidates,target,track,0);
        return ans;
    }


    private void dfs(int[] candidates, int target,List<Integer> track,int index){
        if(target<0){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(track));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            track.add(candidates[i]);
            dfs(candidates,target - candidates[i],track,i);
            track.remove(track.size() - 1);
        }

    }
}
