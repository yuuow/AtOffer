## [第一个只出现一次的字符](https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">字符串</code>

#### 题目描述

> 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 
---
#### 思路一(使用Map)
* 了解 `Map` 中 `getOrDefault` 方法的使用
```java
import java.util.HashMap;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        for (int i = 0; i < str.length(); i++)
            if (map.get(str.charAt(i)) == 1)
                return i;
        return -1;
    }
}
```

#### 思路二
* 使用 `ascii` 差值（字母在 65\~122 之间）创建数组，存储字符出现的次数
```java
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        int[] counts = new int[58];   // 65('A') ~ 122 ('z')
        for (int i = 0; i < str.length(); i++)
            counts[str.charAt(i) - 'A']++;
        for (int i = 0; i < str.length(); i++)
            if (counts[str.charAt(i) - 'A'] == 1)
                return i;
        return -1;
    }
}
```

