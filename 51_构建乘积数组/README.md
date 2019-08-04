## [构建乘积数组](https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

> 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。


----

#### 思路

<img width="60%" src="./images/51_s.jpg">

* B[i] 的值即为上图矩阵中每行的乘积
* 先计算下三角的连乘，然后按照规律，再倒过来连乘上三角


```java
import java.util.ArrayList;

public class Solution {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        int mul = 1;
        for (int i = 0; i < n; i++) {
            B[i] = nul;
            mul *= A[i];
        }
        mul = 1;
        for (int i = n - 1; i >= 0; i--) {
            B[i] *= mul;
            mul *= A[i];
        }
        return B;

    }
}
```