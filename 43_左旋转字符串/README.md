## [左旋转字符串](https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">字符串</code>

#### 题目描述

> 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

#### 思路一(字符串拼接)
```java
public class Solution {
    public String LeftRotateString1(String str, int n) {
        if (str == null || str.length() == 0)
            return "";
        if (n == str.length() || n == 0)
            return str;
        StringBuilder res = new StringBuilder(str.substring(n));
        res.append(str.substring(0, n));
        return res.toString();
    }
```

#### 思路二(字符串反转)
* 先分别将两个部分翻转，再将整体翻转 (A<sup>T</sup>B<sup>T</sup>)<sup>T</sup> = BA
```java
public class Solution {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0)
            return "";
        if (str.length() == 1 || str.length() == n)
            return str;
        char[] chs = str.toCharArray();
        reverse(chs, 0, n - 1);
        reverse(chs, n, str.length() - 1);
        reverse(chs, 0, str.length() - 1);
        return new String(chs);
    }

    private void reverse(char[] chs, int L, int R) {
        for (; L < R; L++, R--) {
            char c = chs[L];
            chs[L] = chs[R];
            chs[R] = c;
        }
    }
}
```