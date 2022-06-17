package techArticle.algorithm.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
//https://leetcode-cn.com/problems/restore-ip-addresses/
public class Leetcode93 {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        dfs(nums,track,0);
        return ans;
    }

    private void dfs(int[] nums,List<Integer> track,int index){

    }

}
