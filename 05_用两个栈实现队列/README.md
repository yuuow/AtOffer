## [用两个栈实现队列](https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">队列</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">栈</code>

#### 题目描述

> 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

-----
#### 思路一(推荐)
* `push` 直接放入 `stack1`
* 当 `stack2` 为空时，将 `stack1` 全部放入到 `stack2` 中，`pop` 操作直接取 `stack2` 栈顶
```java
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty())
            throw new RuntimeException("Queue is empty!");
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }
}
```
#### 思路二(轮流倒装，比较麻烦)
* `stack2` 不为空时，将 `stack2` 全部放入到 `stack1` 中,然后进行 `push` 操作
* `stack1` 不为空时，将 `stack1` 全部放入到 `stack2` 中，然后进行 `pop` 操作取 `stack2` 栈顶
```java
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        while(!stack2.isEmpty())
            stack1.push(stack2.pop());
        stack1.push(node);
    }
    
    public int pop() {
        if(stack1.isEmpty()&&stack2.isEmpty())
            throw new RuntimeException("Queue is empty!");
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());
        return stack2.pop();
    }
}
```