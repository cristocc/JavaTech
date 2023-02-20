package techArticle.algorithm.leetcode.interview;

import java.util.*;

/**
 * Created by crist on 2022/8/9
 * https://leetcode.cn/problems/TVdhkn/
 * @author cc
 */
public class LeetCode_subsets {
    List<List<Integer>> ans = new ArrayList<>();
    Set<Integer> temp = new HashSet<>();
    List<Integer> t = new ArrayList<Integer>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return ans;
    }

    private void dfs(int[] nums,int index){
        ans.add(new ArrayList<>(temp));
        for(int i = index;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(nums,i+1);
            temp.remove(nums[i]);
        }
    }
    public void dfs1(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs1(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs1(cur + 1, nums);
    }






}
