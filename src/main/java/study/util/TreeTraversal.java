package study.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/5/19
 *
 * @author cc
 */
public class TreeTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root,result);
        return result;
    }

    //前序遍历
    public void preorderTraversal(TreeNode root, List<Integer> result){
        if(null == root){
            return;
        }
        result.add(root.val);
        preorderTraversal(root.left,result);
        preorderTraversal(root.right,result);
    }

    int depth = 1;

    public int maxDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        depth(root,depth);
        return depth;

    }

    public void depth(TreeNode root,int depth){
        if(null == root){
            return ;
        }
        if(root.left == null && root.right ==null){
            this.depth = Math.max(this.depth,depth);
        }
        depth(root.left,depth+1);
        depth(root.right,depth+1);
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(null == root){
            return false;
        }
        if(null == root.left && null == root.right && root.val == targetSum){
            return true;
        }
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }



}
