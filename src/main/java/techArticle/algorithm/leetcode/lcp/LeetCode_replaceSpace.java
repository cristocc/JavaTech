package techArticle.algorithm.leetcode.lcp;

import techArticle.algorithm.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2022/7/13
 *
 * @author cc
 */
public class LeetCode_replaceSpace {
    List<Integer> list = new ArrayList();

    public int[] reversePrint(ListNode head) {
        print(head);
        int [] ans = new int[list.size()];
        for(int i = 0;i<ans.length;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void print(ListNode node){
        if(null == node){
            return;
        }
        print(node.next);
        list.add(node.val);
    }
}
