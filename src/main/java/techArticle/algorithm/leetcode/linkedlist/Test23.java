package techArticle.algorithm.leetcode.linkedlist;

import java.util.PriorityQueue;

/**
 * Created by crist on 2022/6/6
 *
 * @author cc
 */
public class Test23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        for(ListNode head : lists ){
            if(head != null){
                pq.offer(head);
            }
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            if(node.next != null){
                pq.offer(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

}
