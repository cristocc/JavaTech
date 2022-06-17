package techArticle.algorithm.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
//https://leetcode-cn.com/problems/combination-sum-ii/
public class Leetcode40 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> track = new ArrayList<>();
        Arrays.sort(candidates);
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
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            track.add(candidates[i]);
            dfs(candidates,target - candidates[i],track,i+1);
            track.remove(track.size() - 1);
        }
    }

}
