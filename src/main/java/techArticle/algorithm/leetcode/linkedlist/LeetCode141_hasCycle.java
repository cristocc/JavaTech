package techArticle.algorithm.leetcode.linkedlist;

import java.util.PriorityQueue;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author cc
 */
public class LeetCode141_hasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode slow = head;
        while(first != null && first.next != null){
            first = first.next.next;
            slow = slow.next;
            if(first == slow){
                return true;
            }
        }
        return false;
    }
}
