package techArticle.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/4/13
 *
 * @author cc
 */
public class LeetCode687_longestUnivaluePath {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int ans = 0, cur = 0, l = dfs(root.left), r = dfs(root.right);
        if (root.left != null && root.left.val == root.val) {
            ans = l + 1; cur += l + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            ans = Math.max(ans, r + 1); cur += r + 1;
        }
        max = Math.max(max, cur);
        return ans;
    }


}
