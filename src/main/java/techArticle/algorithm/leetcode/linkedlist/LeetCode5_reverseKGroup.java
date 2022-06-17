package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @author cc
 */
public class LeetCode5_reverseKGroup {

    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverseLinkedList(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverseLinkedList(ListNode head,ListNode tail) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
