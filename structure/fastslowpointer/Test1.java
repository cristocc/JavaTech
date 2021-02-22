package com.data.structure.fastslowpointer;


/**
 * Created by crist on 2020/12/15
 *
 * @author cc
 */
public class Test1 {

    class ListNode {
        int val;
        ListNode next;
    }
/*    但是如果链表中含有环，那么这个指针就会陷入死循环，因为环形数组中没有 null 指针作为尾部节点。
    经典解法就是用两个指针，一个跑得快，一个跑得慢。如果不含有环，跑得快的那个指针最终会遇到 null，说明链表不含环；如果含有环，快指针最终会超慢指针一圈，和慢指针相遇，说明链表含有环。*/

    boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char test = ('A' | ' ');
        System.out.println(String.valueOf(test));

    }
}
