package techArticle.algorithm.leetcode.tree;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode684_findRedundantConnection {

    private int cnt = 0;
    private int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        f(root, k);
        return ans;
    }

    public void f(TreeNode root, int k) {
        if(root == null)
            return ;
        f(root.left, k);
        cnt++;
        if (cnt == k) {
            ans = root.val;
            return;
        }
        f(root.right, k);
    }
}
