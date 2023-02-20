package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode147_insertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummy;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        int [] arr = {4,2,1,3};
        ListNode head =  ListNode.arrToListNode(arr);

        LeetCode147_insertionSortList test = new LeetCode147_insertionSortList();
        test.insertionSortList(head);
    }

}
