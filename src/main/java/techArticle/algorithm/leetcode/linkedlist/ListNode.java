package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2022/3/11
 *
 * @author cc
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static ListNode arrToListNode(int[] arr){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for(int val:arr){
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}
