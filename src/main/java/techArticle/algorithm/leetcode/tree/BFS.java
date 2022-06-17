package techArticle.algorithm.leetcode.tree;

import java.util.*;

/**
 * Created by crist on 2022/3/4
 *
 * @author cc
 */
public class BFS {
    int minDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if( node.right != null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }


    int res = Integer.MAX_VALUE;

    int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;

    }

}
