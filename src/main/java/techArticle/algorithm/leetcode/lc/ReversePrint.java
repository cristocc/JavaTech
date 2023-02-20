package techArticle.algorithm.leetcode.lc;

import techArticle.algorithm.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2022/7/27
 *
 * @author cc
 */
public class ReversePrint {

/*    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    输入：head = [1,3,2]
    输出：[2,3,1]*/
    List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        dfs(head);
        int[] ans = new int[list.size()];
        for(int i = 0 ;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void dfs(ListNode node){
        if(null == node){
            return;
        }
        dfs(node.next);
        list.add(node.val);
    }
}
