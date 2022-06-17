package techArticle.algorithm.leetcode.tree;

/**
 * Created by crist on 2021/4/27
 *https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * @author cc
 */
public class LeetCode701_insertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}
