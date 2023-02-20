package techArticle.algorithm.leetcode.lcp;

import techArticle.algorithm.leetcode.linkedlist.ListNode;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_removeNthFromEnd {

    int len = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        getLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 1; i < len - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public void getLength(ListNode head) {
        while (head != null) {
            ++len;
            head = head.next;
        }
    }


    public static void main(String[] args) {
        int [] a = {1,2};
        ListNode node = ListNode.arrToListNode(a);
        LeetCode_removeNthFromEnd test = new LeetCode_removeNthFromEnd();
        test.removeNthFromEnd(node,2);
    }
}
