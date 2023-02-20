package techArticle.algorithm.leetcode.middle.Linkedlist;

import techArticle.algorithm.leetcode.linkedlist.ListNode;

/**
 * Created by crist on 2022/7/19
 *
 * @author cc
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode oddHead = head;
        ListNode oddCur = oddHead;

        ListNode evenHead = head.next;
        ListNode evenCur = evenHead;

        while (evenCur != null && evenCur.next != null){
            oddCur.next = oddCur.next.next;
            evenCur.next = evenCur.next.next;
            oddCur = oddCur.next;
            evenCur =  evenCur.next;
        }
        oddCur.next = evenHead;
        return oddHead;

    }
}
