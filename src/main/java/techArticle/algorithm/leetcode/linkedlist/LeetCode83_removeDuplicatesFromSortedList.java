package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode83_removeDuplicatesFromSortedList {


    public static void main(String[] args) {
        int[] a = {1,1,2,2,3,4,5,6,6};
        ListNode head = init(a);
        ListNode result = deleteDuplicates(head);
        System.out.println(result);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }


    private static ListNode init(int[] x){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(int i=0;i<x.length;i++){
            ListNode node = new ListNode(x[i]);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
