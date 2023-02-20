package techArticle.algorithm.leetcode.tree;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode_convertBST {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root){
        if(null == root){
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
