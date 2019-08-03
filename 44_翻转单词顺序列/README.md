## [翻转单词顺序列](https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">字符串</code>

#### 题目描述

> 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

---

#### 思路一(字符串切割)
* 字符串切割成单个单词，再逐个拼接 
```java
public class Solution {
    public String ReverseSentence(String str) {
        if (str.trim().equals(""))
            return str;
        StringBuilder sb = new StringBuilder();
        String[] strs = str.split(" ");
        for (int i = strs.length - 1; i > 0; i--)
            sb.append(strs[i]).append(" ");
        sb.append(strs[0]);
        return sb.toString();
    }
}
```

#### 思路二(书上题解)
* 先翻转整个字符串，再翻转单个单词
* 比如 `student. a am I` -> `I ma a .tneduts` -> `I am a student.`
```java
public class Solution {
    public String ReverseSentence2(String str) {
        if (str.trim().equals(""))
            return str;
        int n = str.length();
        char[] chs = str.toCharArray();
        // 1. 先翻转整个字符串
        reverse(chs, 0, n - 1);

        for (int i = 0; i < n;) {
            // 跳过空格 
            while (i < n && chs[i] == ' ')
                i++;
            int L = i, R = i;
            for (; i < n && chs[i] != ' '; i++, R++)
                ;
            // 2. 再反转单个单词
            reverse(chs, L, R - 1);
        }
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