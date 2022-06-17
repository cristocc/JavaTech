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
public class Leetcode47 {

    List<List<Integer>> ans = new ArrayList<>();
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        dfs(nums,track,0);
        return ans;
    }


    private void dfs(int[] candidates,List<Integer> track,int index){

        if(track.size() == candidates.length){
            ans.add(new ArrayList<>(track));
            return;
        }
        for(int i=0;i<candidates.length;i++){
            if (vis[i] || (i > 0 && candidates[i] == candidates[i - 1] && !vis[i - 1])) {
                continue;
            }

            track.add(candidates[i]);
            vis[i] = true;
            dfs(candidates,track,index+1);
            vis[i] = false;
            track.remove(index);
        }
    }

}
