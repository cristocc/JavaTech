package techArticle.algorithm.leetcode.tree;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode563_findTilt {
    int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root){
        if(null == root){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += Math.abs(left - right);

        return left + right + root.val;
    }

}
