package techArticle.algorithm.leetcode.array;

import java.util.*;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode216_combinationSum3 {

    int[] nums ={0,1,2,3,4,5,6,7,8,9};
    boolean[] used ={true,false,false,false,false,false,false,false,false,false};
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k,n,1);
        return result;
    }

    public void backtrack(int k, int n,int i){
        if(k <0 || n <0){
            return;
        }
        if(k == 0 && n == 0){
            result.add(new ArrayList<>(track));
            return;
        }
        for(;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(k - 1 ,n-nums[i],i+1);
            track.removeLast();
            used[i] = false;
        }
    }
}
