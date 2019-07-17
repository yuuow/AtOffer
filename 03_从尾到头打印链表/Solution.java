
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = listNode;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private ArrayList<Integer> res;

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        res = new ArrayList<>();
        rec(listNode);
        return res;
    }

    public void rec(ListNode cur) {
        if (cur == null)
            return;
        rec(cur.next);
        res.add(cur.val);
    }

}