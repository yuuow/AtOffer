## [复杂链表的复制](https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">链表</code>

#### 题目描述
> 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

---
#### 思路一(使用HashMap)
* 遍历链表，将原节点和副本节点分别保存到 `HashMap` 的键和值中
* `map.get(cur).next = map.get(cur.next)` 和 `map.get(cur).random = map.get(cur.random)`
* 依次将原节点的节点属性拷贝到副本节点
* 最后返回副本节点的头结点 `map.get(pHead)`
```java
import java.util.HashMap;

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }
}
```

#### 方法二(O(1)空间)
* 遍历链表，将副本节点`copy`放在`cur`和下一个要遍历结点的中间
* `原节点 -> 元节点副本(无属性关系) -> 原节点的下一个节点` -> 原节点的下一个节点的副本...
* 最优解，代码逻辑可能很杂乱，**理清拷贝后链表的顺序结构**
* 引用类型是地址值的改变，会改变原变量的值
```java
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode cur = pHead, next;
        //先拷贝一份原来的链表
        while (cur != null) {
            next = cur.next;  //先存着之前的next
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }

        //复制结点的random指针
        cur = pHead;
        RandomListNode copyCur = null;
        while (cur != null) {
            next = cur.next.next; //保存原来链表中的下一个
            copyCur = cur.next; //复制链表的cur
            copyCur.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }

        //拆开两个链表
        RandomListNode copyHead = pHead.next;
        cur = pHead;
        while (cur != null) {
            next = cur.next.next;
            copyCur = cur.next;
            //恢复拆分
            cur.next = next;
            //next.next 下一个原节点指向 下一个源节点它的副本
            copyCur.next = next != null ? next.next : null;
            cur = next;
        }
        return copyHead;
    }
}
```
