package techArticle.algorithm.leetcode.tree;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by crist on 2021/4/13
 *https://leetcode-cn.com/problems/delete-node-in-a-bst/
 *
 * @author cc
 */
public class LeetCode671_findSecondMinimumValue {

    HashSet<Integer> set = new HashSet<>();

    public int findSecondMinimumValue(TreeNode root) {
        if(root.left == null || root.right == null){
            return -1;
        }
        dfs(root);
        int size = set.size();
        if(size == 1){
            return -1;
        }
        Integer[] ans =new Integer[size];
        ans= set.toArray(ans);
        Arrays.sort(ans);
        return ans[1];
    }

    private void dfs(TreeNode node){
        if(null == node){
            return;
        }
        int val = node.val;
        set.add(val);
        dfs(node.left);
        dfs(node.right);
    }



}
