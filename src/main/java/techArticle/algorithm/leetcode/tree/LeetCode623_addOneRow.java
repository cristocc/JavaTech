package techArticle.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by crist on 2021/4/13
 *
 * @author cc
 */
public class LeetCode623_addOneRow {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int d = 1;

        while (d < depth - 1){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if( node.right != null){
                    queue.offer(node.right);
                }
            }
            d++;
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        return root;
    }


    public TreeNode addOneRow1(TreeNode t, int v, int d) {
        if(d == 1){
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        }
        dfs(t,v,d,1);
        return t;
    }

    private void dfs(TreeNode node, int v, int d,int depth){
        if(node == null){
            return;
        }
        if(depth == d-1){
            TreeNode t = node.left;
            node.left = new TreeNode(v);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(v);
            node.right.right = t;
        }else {
            dfs(node.left,v,d,depth+1);
            dfs(node.right,v,d,depth+1);
        }

    }


}
