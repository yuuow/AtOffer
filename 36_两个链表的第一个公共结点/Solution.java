import java.util.HashSet;

public class Solution {
    // 方法一 使用map
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        for (ListNode cur = pHead1; cur != null; cur = cur.next)
            set.add(cur);
        for (ListNode cur = pHead2; cur != null; cur = cur.next)
            if (set.contains(cur))
                return cur;
        return null;
    }

    // 方法二 
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        int l1 = len(pHead1), l2 = len(pHead2);
        ListNode p1 = l1 > l2 ? pHead1 : pHead2;
        ListNode p2 = l1 > l2 ? pHead2 : pHead1;
        for (int i = 0; i < Math.abs(l1 - l2); i++)
            p1 = p1.next;
        for (; p1 != null && p1 != p2; p1 = p1.next, p2 = p2.next)
            ;
        return p1;
    }

    private int len(ListNode node) {
        int len = 0;
        for (ListNode cur = node; cur != null; cur = cur.next)
            len++;
        return len;
    }

    //方法三
    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead1 : p1.next;
            p2 = p2 == null ? pHead2 : p2.next;
        }
        return p1;
    }
}