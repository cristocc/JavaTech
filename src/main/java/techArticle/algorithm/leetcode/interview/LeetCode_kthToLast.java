package techArticle.algorithm.leetcode.interview;

import techArticle.algorithm.leetcode.linkedlist.ListNode;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_kthToLast {

    public int kthToLast(ListNode head, int k) {
        ListNode dummy = head;
        int len = 0;
        while (dummy != null){
            dummy = dummy.next;
            len++;
        }
        dummy = head;
        for(int i=0;i < len - k +1;i++){
            dummy = dummy.next;
        }

        return dummy.val;

    }
}
