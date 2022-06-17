package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2022/6/6
 *
 * @author cc
 */
public class Test206 {


    public ListNode reverseList(ListNode head) {
        if(null == head || head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
