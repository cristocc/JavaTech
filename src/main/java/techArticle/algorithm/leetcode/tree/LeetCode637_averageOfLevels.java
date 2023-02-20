package techArticle.algorithm.leetcode.tree;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode637_averageOfLevels {

    // 定义：将以 root 为根的树拉平为链表
    void flatten(TreeNode root) {
        // base case
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
/*                1
            /       \
            2       5
           / \       \
          3  4         6*/


}
