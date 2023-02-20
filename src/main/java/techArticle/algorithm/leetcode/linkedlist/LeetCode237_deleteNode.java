package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode237_deleteNode {


    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;

    }


}
