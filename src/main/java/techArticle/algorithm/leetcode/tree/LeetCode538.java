package techArticle.algorithm.leetcode.tree;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode538 {
    TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    int sum = 0;// 记录累加和
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        sum += root.val;// 维护累加和
        root.val = sum;// 将 BST 转化成累加树
        traverse(root.left);
    }
}
