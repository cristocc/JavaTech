package tree;

/**
 * Created by crist on 2021/5/18
 *
 * @author cc
 */
public class TreeHasPathSum {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(null == root){
            return false;
        }
        if(root.left==null && root.right==null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }



}
