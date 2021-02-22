package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by crist on 2020/11/24
 *
 * @author cc
 */
public class Info {

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
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
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

    // 3,9,20,null,nul,15,7
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9,null,null);
        TreeNode node15 = new TreeNode(15,null,null);
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node20 = new TreeNode(20,node15,node7);
        TreeNode node1 = new TreeNode(3,node9,node20);

        minDepth(node1);

    }
/*    // 计算从起点 start 到终点 target 的最近距离
    int BFS(Node start, Node target) {
        Queue<Node> q; // 核心数据结构
        Set<Node> visited; // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数

        while (q not empty) {
            int sz = q.size();
            *//* 将当前队列中的所有节点向四周扩散 *//*
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                *//* 划重点：这里判断是否到达终点 *//*
                if (cur is target)
                return step;
                *//* 将 cur 的相邻节点加入队列 *//*
                for (Node x : cur.adj())
                    if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
            }
            *//* 划重点：更新步数在这里 *//*
            step++;
        }

        队列 q 就不说了，BFS 的核心数据结构；cur.adj() 泛指 cur 相邻的节点，比如说二维数组中，cur 上下左右四面的位置就是相邻节点；
        visited 的主要作用是防止走回头路，大部分时候都是必须的，但是像一般的二叉树结构，没有子节点到父节点的指针，不会走回头路就不需要 visited。
    }*/
}
