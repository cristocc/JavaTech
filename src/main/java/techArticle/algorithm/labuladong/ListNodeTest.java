package techArticle.algorithm.labuladong;

import java.util.PriorityQueue;

/**
 * Created by crist on 2021/11/9
 *
 * @author cc
 */
public class ListNodeTest {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //合并 k 个有序链表
   static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }
        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

// 返回链表的倒数第 k 个节点
    static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }


    // 主函数
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    public static ListNode remove(ListNode head, int n){
        ListNode dummy = head;
        ListNode ret = new ListNode(-1);
        ListNode temp = ret;
        while(dummy !=null){
            int val = dummy.val;
            if(val == n){
                //dummy = dummy.next;
                temp.next = new ListNode();
            }else{
                temp.val = val;
                temp.next = new ListNode();
            }
            temp = temp.next;
            dummy = dummy.next;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] nums2 = {2,3,7};
        ListNode l1 = getNode(nums);
        ListNode l2 = getNode(nums2);
        ListNode[] listNodes = {l1,l2};
        reverse2(l1);
        //reverse(l1);
        //remove(l1,1);
        //mergeKLists(listNodes);
        //ListNode l3 = removeNthFromEnd(l1,2);
        //System.out.println(l3);
    }

    static ListNode getNode(int[] nums){
        ListNode node = new ListNode();
        ListNode l1 = node;
        for(int i=0;i < nums.length;i++){
            l1.val = nums[i];
            if(i != nums.length -1 ){
                l1.next =  new ListNode();
                l1 = l1.next;
            }

        }
        return node;
    }

    static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

   static ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    static  ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

   static ListNode reverse2(ListNode head) {
        // 1->2->3->4->5
       //
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
