package techArticle.algorithm.leetcode.tree;

/**
 * Created by crist on 2022/3/4
 *
 * @author cc
 */
public class TreeNode {
   public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
