package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode2_addTwoNumbers {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = init(2,4,3);
        ListNode l2 = init(5,6,4);
        addTwoNumbers(l1,l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (null != l1 || null != l2){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;

        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    private static ListNode init(int x,int y ,int z){
        ListNode node1 = new ListNode(x);
        ListNode node2 = new ListNode(y);
        ListNode node3 = new ListNode(z);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }


}
