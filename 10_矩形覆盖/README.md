## [矩形覆盖](https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">递归</code>

#### 题目描述

> 我们可以用2\*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2\*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

---
#### 思路
> 参考 [08_跳台阶](../08_跳台阶)，代码完全一样

* 当 `n < 1` 时，不需要覆盖，直接返回 0
* 当 ` n = 1 ` 时，只存在一种情况，返回 1 
* 当 ` n = 2 ` 时，存在两种情况，返回 2
* 当 n 时，尝试反向推导，即可得出 `f(n) = f(n-1) + f(n-2)`
