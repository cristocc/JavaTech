package techArticle.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/4/25
 *https://leetcode-cn.com/problems/increasing-order-search-tree/
 * @author cc
 */
public class LeetCode897_IncreasingBST {


    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for (int value : res) {
            currNode.right = new TreeNode(value);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }


}
