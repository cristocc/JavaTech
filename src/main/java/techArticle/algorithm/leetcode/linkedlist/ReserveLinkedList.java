package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2022/1/4
 *
 * @author cc
 */
public class ReserveLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    //1->2->null
    //2->1->null;
    private ListNode reserved(ListNode node){
        if(node.next == null){
            return node;
        }
        ListNode last = reserved(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }

    private ListNode reserved2(ListNode node){
        ListNode cur = node;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
