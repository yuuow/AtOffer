## [把字符串转换成整数](https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">字符串</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">进制转化</code>

#### 题目描述

> 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。

#### 输入描述

> 输入一个字符串,包括数字字母符号,可以为空

#### 输出描述

> 如果是合法的数值表达则返回该数字，否则返回0

##### 示例一
输入
```
+2147483647
    1a33
```
输出
```
2147483647
    0
```
----
#### 思路
* 字符串转字符数组，再单个字符逐一操作，第一个符号要进行判断
* 操作字符串要十分注意空字符
```java
public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.trim().equals(""))
            return 0;
        char[] chs = str.trim().toCharArray();
        int res = 0;
        for (int i = (chs[0] == '-' || chs[0] == '+') ? 1 : 0; i < str.length(); i++) {
            if (chs[i] < '0' || chs[i] > '9')
                return 0;
            int num = chs[i] - '0';
            res = res * 10 + num;
        }
        return chs[0] == '-' ? -res : res;
    }
}
```
