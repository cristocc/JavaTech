package techArticle.algorithm.leetcode.linkedlist;

import java.util.List;

/**
 * Created by crist on 2022/6/6
 *
 * @author cc
 */
public class Test92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=0;i<left-1;i++){
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for(int i=0;i<right-left+1;i++){
            rightNode = rightNode.next;
        }
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverseList(leftNode);
        pre.next = rightNode;
        leftNode.next = cur;
        return dummy.next;
    }


    public ListNode reverseList(ListNode head) {
        if(null == head || head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }



}
