package techArticle.algorithm.leetcode.linkedlist;

import java.util.HashSet;
import java.util.logging.Handler;

/**
 * Created by crist on 2022/7/1
 *
 * @author cc
 */
public class Leetcode_160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        HashSet<ListNode> set = new HashSet<>();
        while(temp != null){
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            if(set.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

}
