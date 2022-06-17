package techArticle.algorithm.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author cc
 */
public class LeetCode160_getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;

    }

}
