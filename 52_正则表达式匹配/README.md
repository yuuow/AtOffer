## [正则表达式匹配](https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">字符串</code>

#### 题目描述

> 请实现一个函数用来匹配包括'.'和'\*'的正则表达式。模式中的字符'.'表示任意一个字符，而'\*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab\*ac\*a"匹配，但是与"aa.a"和"ab*a"均不匹配


----
#### 思路(递归)
* `dp[ls][lp] != 0` 减少重复运算，保存了先前的判断结果 ` dp[ls][lp] = res ? 1 : -1`
* 注意正则表达式的匹配问题，要考虑每次可能的匹配结果（零次/一次/多次）
```java
public class Solution {

    private int[][] dp;

    public boolean match(char[] str, char[] pattern) {
        dp = new int[str.length + 1][pattern.length + 1];
        return isMatch(str, pattern, str.length, pattern.length);
    }

    private boolean isMatch(char[] s, char[] p, int ls, int lp) {
        if (ls == 0 && lp == 0)
            return true;
        if (dp[ls][lp] != 0)
            return dp[ls][lp] == 1;
        if (lp == 0)
            return false;
        boolean res = false;
        if (ls == 0) {
            res = lp >= 2 && p[lp - 1] == '*' && isMatch(s, p, ls, lp - 2);
        } else {
            if (p[lp - 1] == '.' || p[lp - 1] == s[ls - 1]) {
                res = isMatch(s, p, ls - 1, lp - 1);
            } else if (p[lp - 1] == '*') {
                if (p[lp - 2] == '.')
                    res = isMatch(s, p, ls - 1, lp - 1) || isMatch(s, p, ls - 1, lp) || isMatch(s, p, ls, lp - 2);
                else if (s[ls - 1] == p[lp - 2]) {
                            || isMatch(s, p, ls - 1, lp) || isMatch(s, p, ls, lp - 2);
                } else
                    //p[lp - 2] != '.' && s[ls - 1] != p[lp - 2] a*匹配0次
                    res = isMatch(s, p, ls, lp - 2);
            }
        }
        dp[ls][lp] = res ? 1 : -1;
        return res;
    }
}
```

