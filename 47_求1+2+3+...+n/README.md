## [求1+2+3+...+n](https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">进制转化</code>

#### 题目描述

> 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。


---
#### 思路(递归)
* 利用逻辑与的短路特性实现递归终止
* 当 `n == 0` 时，`n > 0 && (res += Sum_Solution(n-1)) > 0` 只执行前面的判断，为 `false`，然后直接返回 `0`；
* 当 `n > 0` 时，执行 `res += Sum_Solution(n-1)`，实现递归计算`Sum_Solution(n)`；

```java
public class Solution {
    public int Sum_Solution(int n) {
        int res = n;
        boolean b = n > 0 && (res += Sum_Solution(n - 1)) > 0;
        return res;
    }
}
```