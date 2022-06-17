package techArticle.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/4/13
 * https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/
 * @author cc
 */
public class LeetCode1373_maxSumBST {

    int ans = 0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return ans;
    }

    int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        // 递归计算左右子树
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] res = new int[4];
        // 这个 if 在判断以 root 为根的二叉树是不是 BST
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            // 以 root 为根的二叉树是 BST
            res[0] = 1;
            // 计算以 root 为根的这棵 BST 的最小值
            res[1] = Math.min(left[1], root.val);
            // 计算以 root 为根的这棵 BST 的最大值
            res[2] = Math.max(right[2], root.val);
            // 计算以 root 为根的这棵 BST 所有节点之和
            res[3] = left[3] + right[3] + root.val;
            // 更新全局变量
            ans = Math.max(ans, res[3]);
        } else {
            // 以 root 为根的二叉树不是 BST
            res[0] = 0;
        }
        return res;
    }

}
