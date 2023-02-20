package techArticle.algorithm.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by crist on 2021/4/13
 *
 * @author cc
 */
public class LeetCode919_CBTInserter {
    Queue<TreeNode> candidate;
    TreeNode root;

    public LeetCode919_CBTInserter(TreeNode root) {
        this.candidate = new ArrayDeque<>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (!(node.left != null && node.right != null)) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int ret = node.val;
        if (node.left == null) {
            node.left = child;
        } else {
            node.right = child;
            candidate.poll();
        }
        candidate.offer(child);
        return ret;
    }

    public TreeNode get_root() {
        return root;
    }

}
