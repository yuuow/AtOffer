## [包含min函数的栈](https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">栈</code>

#### 题目描述

> 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

---
#### 思路
* 要点 考虑 **时间复杂度应为O(1)**
* 使用两个栈，`stackData` 是数据栈(存储数据)，`stackMin` 是辅助栈(存储最小元素)
```java
import java.util.Stack;

public class Solution {

    Stack<Integer> stackData = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        stackData.push(node);
        if (stackMin.isEmpty())
            stackMin.push(node);
        else {
            // 需要等号，因为弹出时需要计算相等情况(要考虑重复因素)
            if (node <= stackMin.peek())
                stackMin.push(node);
            // else  重复压入，直接弹出
            //     stackmin.push(stackMin.peek());

        }
    }

    public void pop() {
        int top = stackData.pop();
        if (top == stackMin.peek())
            stackMin.pop();
        //stackMin.pop();  直接弹出
    }

    public int top() {
        if (stackData.isEmpty())
            throw new RuntimeException("stack is empty!");
        return stackData.peek();
    }

    public int min() {
        if (stackMin.isEmpty())
            throw new RuntimeException("stack is empty!");
        return stackMin.peek();
    }
}
```