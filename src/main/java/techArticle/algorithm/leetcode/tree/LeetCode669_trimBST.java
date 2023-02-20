package techArticle.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode669_trimBST {

    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ans = Math.max(size,ans);
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }
}
