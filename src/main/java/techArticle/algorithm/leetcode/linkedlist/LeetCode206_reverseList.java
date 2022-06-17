package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2021/3/26
 *https://leetcode-cn.com/problems/reverse-linked-list/
 * @author cc
 */
public class LeetCode206_reverseList {

    // 1->2
    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    private static void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ListNode node = ListNode.arrToListNode(arr);
        reverseLinkedList(node);
    }



}
