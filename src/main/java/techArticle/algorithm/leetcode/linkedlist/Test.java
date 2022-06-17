package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2022/5/26
 *
 * @author cc
 */
public class Test {

    //1->2->3
    public ListNode reserve(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode last = reserve(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }

    //  3,2,1
    private ListNode reserved2(ListNode node){
        ListNode pre = null;
        ListNode cur = node; //1,2,3
        while (cur != null){
            ListNode next = node.next; // 2,3
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
