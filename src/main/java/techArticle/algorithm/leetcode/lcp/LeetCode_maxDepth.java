package techArticle.algorithm.leetcode.lcp;

import techArticle.algorithm.leetcode.linkedlist.ListNode;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_maxDepth {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode point = head;
                while (point != slow) {
                    point = point.next;
                    slow = slow.next;
                }
                return point;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        LeetCode_maxDepth test = new LeetCode_maxDepth();
        test.detectCycle(a);
    }
}
