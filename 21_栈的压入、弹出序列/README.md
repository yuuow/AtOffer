## [栈的压入、弹出序列](https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">栈</code>

#### 题目描述

> 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
---
> 参考 [ZXZxin解析](https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/Other/%E5%89%91%E6%8C%87Offer/%E5%89%91%E6%8C%87Offer%20-%2021%20-%20%E6%A0%88%E7%9A%84%E5%8E%8B%E5%85%A5%E3%80%81%E5%BC%B9%E5%87%BA%E5%BA%8F%E5%88%97.md)
* 使用额外的一个辅助栈
#### 思路一
* 遍历 `pushA`，使用索引 `popIndex` 记录 `popA` 中移动的位置
* 如果`pushA[i] == popA[popIndex]` ，则 `popIndex++`，移动位置，否则入栈 `stack.push(pushA[i])`
* 然后 `stack` 弹栈(直到为空)，如果 `stack.pop() != popA[popIndex++]`，返回 `false`
```java
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] == popA[popIndex])
                popIndex++;
            else
                stack.push(pushA[i]);
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popA[popIndex++])
                return false;
        }
        return true;
    }
}
```

#### 思路二
* 遍历 `pushA` ，入栈 `stack.push(pushA[i])`
* 还是使用索引 `popIndex` 记录 `popA` 中移动的位置
* (while)如果 `stack.peek() == popA[popIndex]`且`stack`不为空，则 `stack.pop()` 且 `popIndex++`
* 最后判断 `stack` 是否为空
```java
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
```