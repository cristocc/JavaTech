package techArticle.algorithm.leetcode.tree;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode938_RangeSumBst {


    int res= 0 ;
    int _low = 0;
    int _high = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        _low = low;
        _high = high;
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root){
        if(null == root){
            return;
        }
        inorder(root.left);
        if(root.val >= _low && root.val <=_high){
            res += root.val;
        }
        inorder(root.right);
    }
}
