public class Solution {
    //方法一 常规
    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null, next = null, cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //方法二 递归
    public ListNode ReverseList2(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null)
            return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(next, cur);
    }
}