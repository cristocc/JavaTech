package techArticle.algorithm.leetcode.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by crist on 2021/3/26
 *
 * @author cc
 */
public class LeetCode2181_mergeNodes {

    public static  ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        Queue<Integer> queue = new LinkedList();
        head = head.next;
        while (head != null){
            if(head.val != 0){
                queue.add(head.val);
            }else{
                int val = 0;
                while (!queue.isEmpty()){
                    val += queue.poll();
                }
                temp.next = new ListNode(val);
                temp = temp.next;

            }
            head = head.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,3,1,0,4,5,2,0};
        ListNode head = ListNode.arrToListNode(a);
        mergeNodes(head);

    }



}
