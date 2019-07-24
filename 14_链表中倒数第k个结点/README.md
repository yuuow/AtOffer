## [链表中倒数第k个结点](https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">链表</code>

#### 题目描述

> 输入一个链表，输出该链表中倒数第k个结点。

---
#### 思路一(常规解法)
* 先遍历，算出链表的长度 `len`
* 然后从头遍历 `len-k` 次，就可以求得倒数第 `k` 个节点
```java
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
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
}
```
#### 思路二(双指针)
* 第一个指针 `fi` 先到 `k-1` 处，然后两个指针一起走
* 当 `fi.next==null` 时(第二个指针正好距离末尾 `k-1` 个位置)
* 第二个指针`se`所指向就是倒数第 `k` 个节点
```java
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
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
```