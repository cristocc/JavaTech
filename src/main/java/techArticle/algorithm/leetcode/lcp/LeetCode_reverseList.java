package techArticle.algorithm.leetcode.lcp;

import techArticle.algorithm.leetcode.linkedlist.ListNode;

import java.util.Arrays;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_reverseList {

    // 1->2

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next = head;
        head.next.next = null;
        return last;
    }


    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
