package structure.reverseLink;

/**
 * Created by crist on 2021/1/27
 *
 * @author cc
 */
public class Test {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }

    }

   static ListNode reverse(ListNode a) {

        // 1->2->3
       ListNode pre = null;
       ListNode cur = a;
       //ListNode nxt = a;
        while (cur != null) {
            ListNode nxt = cur.next;
            // 逐个结点反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        b.next = c;
        a.next = b;
        System.out.println(a);
        reverse(a);
    }
}
