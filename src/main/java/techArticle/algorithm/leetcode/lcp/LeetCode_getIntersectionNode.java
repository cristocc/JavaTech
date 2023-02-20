package techArticle.algorithm.leetcode.lcp;

import techArticle.algorithm.leetcode.linkedlist.ListNode;

import java.util.HashSet;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_getIntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;

        }
        return null;
    }
}
