## [不用加减乘除做加法](https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">进制转化</code>

#### 题目描述

> 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。


---

#### 思路
* 把完全不考虑进位和考虑进位的两种情况相加，就是最终的结果(一直重复这样的过程，直到最后的进位为0)
    * 不考虑进位  `a ^ b` 就是正确结果；因为 `0 + 0 = 0(0 ^ 0)`，`1 + 0 = 1(1 ^ 0)`，`0 + 1 = 1(0 ^ 1)`，`1 + 1 = 0 (1 ^ 1)`。
    * 只考虑进位  `(a & b) << 1` 就是结果；因为第 i 位的结果只有可能是 i - 1 位都为1的情况下才会产生进位
* `^`  异或运算 |  `&`  位与运算

举例
```
1、一开始的值:
a    :   001010101
b    :   000101111
    
2、上面两个异或和&<<1的值:
^    :   001111010
&<<1 :   000001010
    
3、上面两个异或和&<<1的值:
^    :   001110000
&<<1 :   000010100
    
4、上面两个异或和&<<1的值:
^    :   001100100
&<<1 :   000100000
    
5、上面两个异或和&<<1的值:
^    :   001000100
&<<1 :   001000000
    
6、上面两个异或和&<<1的值:
^    :   000000100
&<<1 :   010000000
    
7、上面两个异或和&<<1的值:
^    :   010000100
&<<1 :   000000000    (num2 == 0)
```

代码
```java
public class Solution {
    public int Add(int num1, int num2) {
        int sum = 0, carray = 0;
        while (num2 != 0) {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
```