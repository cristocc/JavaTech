package techArticle.algorithm.leetcode.tree;

/**
 * Created by crist on 2021/4/13
 *https://leetcode-cn.com/problems/-distance-betminimumween-bst-nodes/
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * @author cc
 */
public class LeetCode783_minDiffInBST {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int pre;
    public static int ans;

    public static int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        TreeNode left2 = new TreeNode(2);
        TreeNode right6 = new TreeNode(6);
        TreeNode left1 = new TreeNode(1);
        TreeNode left1_right3 = new TreeNode(3);

        left2.left = left1;
        left2.right = left1_right3;

        root.left = left2;
        root.right = right6;
        minDiffInBST(root);
    }

}
