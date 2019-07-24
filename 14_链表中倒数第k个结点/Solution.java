public class Solution {
    // 思路一 常规解法
    public ListNode FindKthToTail1(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        if (k > len)
            return null;
        cur = head;
        for (int i = 0; i < len - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //思路二 双指针
    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null || k == 0)
            return null;
        ListNode fi = head, se = head;
        for (int i = 0; i < k - 1; i++)
            fi = fi.next;
        if (fi == null)
            return null;
        while (fi.next != null) {
            fi = fi.next;
            se = se.next;
        }
        return se;
    }
}