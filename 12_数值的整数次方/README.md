## [数值的整数次方](https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数学</code>

#### 题目描述

> 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

---
#### 思路一(暴力法)
* 直接模拟该过程，将 `base` 连乘 `exponent` 次。
* 考虑 `exponent < 0` 的特殊情况，可以使用 `1/base`，`-exponent` 代替 `exponent`，`exponent` 保证 `exponent >= 0`
```java
public class Solution {
    public double Power(double base, int exponent) {
        long N = exponent;
        if (N < 0) {
            base = 1 / base;
            N = -N;
        }
        double ans = 1;
        for (int i = 0; i < N; i++)
            ans = ans * base;
        return ans;
    }
}
```
#### 思路二(快速幂算法（递归）)
* 二分相乘递归求解 
```java
public class Solution {
    public double fastPow(double base, long exponent) {
        if (exponent == 0)
            return 1.0;
        double half = fastPow(base, exponent / 2);
        if (exponent % 2 == 0)
            return half * half;
        else
            return half * half * base;
    }

    public double Power(double base, int exponent) {
        long N = exponent;
        if (N < 0) {
            base = 1 / base;
            N = -N;
        }

        return fastPow(base, N);
    }
}
```
#### 思路三(快速幂算法（循环）)
* 二分相乘循环求解
```java
public class Solution {
     public double Power(double base, int exponent) {
        int N = exponent;
        if (N < 0) {
            base = 1 / base;
            N = -N;
        }
        double ans = 1;
        double current_product = base;
        for (int i = N; i > 0; i /= 2) {
            if ((i % 2) == 1)
                ans = ans * current_product;
            current_product *= current_product;
        }
        return ans;
    }
}
```

