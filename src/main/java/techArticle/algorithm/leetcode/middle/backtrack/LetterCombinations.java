package techArticle.algorithm.leetcode.middle.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2022/7/18
 *
 * @author cc
 */
public class LetterCombinations {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    boolean[] used ;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums);
        return ans;
    }

    public void dfs(int[] nums){
        if(track.size() == nums.length){
            ans.add(new ArrayList<>(track));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            dfs(nums);
            track.remove(track.size() - 1);
            used[i] = false;
        }


    }
}
