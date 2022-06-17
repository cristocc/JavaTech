package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2022/6/6
 *
 * @author cc
 */
public class Test19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = head;
        ListNode p2 = dummy;
        for(int i=0;i<n;i++){
            p1 = p1.next;
        }
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }

}
