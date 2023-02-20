package techArticle.algorithm.leetcode.middle.tree;

import techArticle.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2022/7/21
 *
 * @author cc
 */
public class InorderTraversal {

    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if(null == root){
            return;
        }
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}
