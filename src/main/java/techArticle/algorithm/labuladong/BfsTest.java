package techArticle.algorithm.labuladong;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by crist on 2021/11/8
 *
 * @author cc
 */
public class BfsTest {

    static class TreeNode {
        int val;
        TreeNode left, right;

        void traverse(TreeNode root) {
            traverse(root.left);
            traverse(root.right);
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                //System.out.println(cur.val);
                /* 判断是否到达终点 */
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);

            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9,null,null);
        TreeNode node15 = new TreeNode(15,null,null);
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node20 = new TreeNode(20,node15,node7);
        TreeNode node1 = new TreeNode(3,node9,node20);
        System.out.println(minDepth(node1));
    }
}
