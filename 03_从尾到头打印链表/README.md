## [从尾到头打印链表](https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">链表</code>

#### 题目描述

> 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

----
#### 思路一(递归求解）

```java
public class Solution {
    private ArrayList<Integer> res;
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        res = new ArrayList<>();
        rec(listNode);
        return res;
    }
    
    public void rec(ListNode cur) {
        if(cur==null)
            return;
        rec(cur.next);
        res.add(cur.val);
    }
}
```

#### 思路二(使用栈中转)

```java
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
}
```

