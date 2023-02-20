package techArticle.algorithm.leetcode.lcp;

import techArticle.algorithm.leetcode.linkedlist.ListNode;
import techArticle.algorithm.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_detectCycle {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }


}
