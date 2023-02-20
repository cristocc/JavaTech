package techArticle.algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode1379_getTargetCopy {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> clonedQueue = new LinkedList<>();
        queue.offer(original);
        clonedQueue.offer(cloned);
        TreeNode node1;
        TreeNode node2;
        while (!queue.isEmpty()){
            node1 = queue.poll();
            node2 = clonedQueue.poll();
            if (target == node1){
                return node2;
            }
            if (node1.left != null){
                queue.offer(node1.left);
                clonedQueue.offer(node2.left);
            }
            if (node1.right != null){
                queue.offer(node1.right);
                clonedQueue.offer(node2.right);
            }
        }
        return null;

    }
}
