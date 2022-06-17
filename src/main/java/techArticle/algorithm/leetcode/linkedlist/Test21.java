package techArticle.algorithm.leetcode.linkedlist;

/**
 * Created by crist on 2022/6/6
 *
 * @author cc
 */
public class Test21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(list1 != null &&list2 !=null ){
            if(list1.val >list2.val ){
                p.next = list2;
                list2 = list2.next;
            }else {
                p.next = list1;
                list1 = list1.next;
            }
            p = p.next;
        }
        if (list1 != null){
            p.next = list1;
        }
        if (list2 != null){
            p.next = list2;
        }
        return dummy.next;
    }

}
