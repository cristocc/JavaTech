package techArticle.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/permutations/
 * @author cc
 */
public class LeetCode_combine {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int k;
    int max;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.max = n;
        dfs(1);
        return res;
    }

    private void dfs(int n){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = n;i<=max;i++){
            temp.add(i);
            dfs(i+1);
            temp.remove(temp.size()-1);
        }

    }
}
