package techArticle.algorithm.leetcode.lc;

import techArticle.algorithm.leetcode.linkedlist.ListNode;

import java.util.LinkedList;

/**
 * Created by crist on 2022/7/27
 *
 * @author cc
 */
public class ReverseList {

/*    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL*/

    public ListNode reverseList(ListNode head) {
        if(null == head){
            return head;
        }
        dfs(head);
        return head;
    }

    public ListNode dfs(ListNode node){
        if(node.next == null){
            return node;
        }
        ListNode last = dfs(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }



}
