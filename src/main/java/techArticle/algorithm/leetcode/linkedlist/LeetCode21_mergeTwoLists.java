package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2021/3/26
 *https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @author cc
 */
public class LeetCode21_mergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

}
