package techArticle.algorithm.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by crist on 2021/12/29
 *
 * @author cc
 */
//https://leetcode-cn.com/problems/increasing-subsequences/
public class Leetcode491 {

   static List<Integer> track = new ArrayList<>();
    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        //dfs(nums,0,0 );
        dfs(0,0,nums );
        return ans;
    }

    public static void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (track.size() >= 2) {
                ans.add(new ArrayList<>(track));
            }
            return;
        }
        if (nums[cur] >= last) {
            track.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            track.remove(track.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }

/*   private static void dfs(int[] nums,int index,int last){
        if (index == nums.length) {
            if (track.size() > 1) {
                ans.add(new ArrayList<>(track));
            }
            return;
        }
        for(int i=index;i<nums.length;i++){
            if (nums[index] >= last) {
                track.add(nums[i]);
                dfs(nums,i+1,nums[index]);
                track.remove(track.size() - 1);
            }
        }
    }*/

    //[[4,6,7,7],[4,6,7],[4,6],[4,7,7],[4,7],[6,7,7],[6,7],[7,7]]
    //[[4,6,7,7],[4,6,7],[4,7,7],[4,7],[6,7,7],[6,7],[7,7]]
    public static void main(String[] args) {
        int[] a = {4,6,7,7};
        findSubsequences(a);
    }

}
