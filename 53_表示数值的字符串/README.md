## [表示数值的字符串](https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">字符串</code>

#### 题目描述

> 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

----

#### 思路
* 逐个条件依次分析，注意条理
```java
import java.math.BigDecimal;

class Solution {

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        int n = str.length;
        // 最后一个不能为这些
        if (str[n - 1] == 'E' || str[n - 1] == 'e' || str[n - 1] == '.' || str[n - 1] == '+' || str[n - 1] == '-')
            return false;
        boolean sign = false, dot = false, E = false; // 是否出现 +/- 、.　、E/e
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') { //E
                if (E)
                    return false; // 只能出现一个E/e
                if (i == str.length - 1)
                    return false; // E/e后面一定要有东西
                if (i > 0 && (str[i - 1] == '+' || str[i - 1] == '-' || str[i - 1] == '.'))
                    return false; // E/e前面是数字
                E = true;
            } else if (str[i] == '-' || str[i] == '+') { //sign
                // 第二次出现+- 必须在E/e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false; // 第二个符号必须在E的后面
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在E/e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false;
                sign = true;
            } else if (str[i] == '.') { // dot
                if (E || dot)
                    return false; // E/e后面不能有小数点, 小数点不能出现两次 例如: 12e+4.3
                dot = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

}
```