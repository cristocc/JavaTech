package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author cc
 */
public class LeetCode234_isPalindrome {
    ListNode left;

    boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        // 后序遍历代码
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
}
