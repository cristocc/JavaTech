package tree;

/**
 * Created by crist on 2021/5/18
 *
 * @author cc
 */
public class TreeMaxDepth {

    public int maxDepth(TreeNode root) {
        if(null ==root){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }


    int res = 1;
    public int maxDepth1(TreeNode root) {
        if(null == root){
            return 0;
        }
        max(root,res);
        return res;
    }

    public void max(TreeNode root,int depth){
        if(null ==root){
            return;
        }
        if(root.left ==null && root.right == null){
            res = Math.max(res,depth);
        }
        max(root.left,depth+1);
        max(root.right,depth+1);
    }
}
