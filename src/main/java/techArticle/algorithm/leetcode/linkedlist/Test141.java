package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2022/6/6
 *
 * @author cc
 */
public class Test141 {

    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && p1.next !=null){
            p1 = p1.next.next;
            p2 = p2.next;
            if(p1 == p2){
                return true;
            }
        }
        return false;
    }

}
