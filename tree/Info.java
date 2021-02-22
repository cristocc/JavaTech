package tree;

/**
 * Created by crist on 2020/11/23
 *
 * @author cc
 */
public class Info {

    //链表遍历框架，兼具迭代和递归结构
    class ListNode {
        int val;
        ListNode next;

        void traverseFor(ListNode head) {
            for (ListNode p = head; p != null; p = p.next) {
                // 迭代访问 p.val
            }
        }

        void traverse(ListNode head) {
            // 递归访问 head.val
            traverse(head.next);
        }
    }

    //二叉树遍历框架，典型的非线性递归遍历结构
    /* 基本的二叉树节点 */
    class TreeNode {

        int val;
        TreeNode left, right;

        void traverse(TreeNode root) {
            traverse(root.left);
            traverse(root.right);
        }
    }

    /* 基本的 N 叉树节点 */
    class NTreeNode {
        int val;
        NTreeNode[] children;

        void traverse(NTreeNode root) {
            for (NTreeNode child : root.children)
                traverse(child);
        }
    }
}
