package techArticle.algorithm.leetcode.tree;


import techArticle.algorithm.leetcode.linkedlist.ListNode;

/**
 * Created by crist on 2021/4/13
 *
 * @author cc
 */
public class LeetCode109_sortedListToBST {

    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length  = getLength(head);
        return buildTree(0,length - 1);
    }

    private int getLength(ListNode head){
        int res = 0;
        while (head != null){
            res++;
            head = head.next;
        }
        return res;
    }

    private TreeNode buildTree(int left , int right){
        if(left > right){
            return null;
        }
        int middle = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, middle - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(middle + 1, right);
        return root;
    }




}
