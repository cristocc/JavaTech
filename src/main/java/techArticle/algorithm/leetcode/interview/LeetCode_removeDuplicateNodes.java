package techArticle.algorithm.leetcode.interview;

import techArticle.algorithm.leetcode.linkedlist.ListNode;

import java.util.HashSet;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_removeDuplicateNodes {

    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        HashSet<Integer> set = new HashSet<>();
        while (head != null){
            int val = head.val;
            if(!set.contains(val)){
                set.add(val);
                dummy.next = new ListNode(val);
                dummy = dummy.next;
            }
            head = head.next;

        }
        return ans.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,2,1};
        ListNode node = ListNode.arrToListNode(arr);
        removeDuplicateNodes(node);
    }
}
