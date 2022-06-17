package techArticle.algorithm.leetcode.tree;

/**
 * Created by crist on 2021/4/27
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * @author cc
 */
public class LeetCode700_searchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        // 去左子树搜索
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        // 去右子树搜索
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return root;
    }
}
