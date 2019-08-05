## [字符流中第一个不重复的字符](https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">字符串</code>


#### 题目描述

> 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。


#### 输出描述

> 如果当前字符流没有存在出现一次的字符，返回#字符。


----

#### 思路一
* 存入容器容器（每个字符都依次加入，包括重复），查询遍历容器
```java
public class Solution {

    private StringBuilder sb = new StringBuilder();

    private int[] c = new int[256];

    public void Insert(char ch) {
        sb.append(ch);
        c[ch]++;
    }
    
    public char FirstAppearingOnce() {
        for(int i = 0; i < sb.length(); i++) if(c[sb.charAt(i)] == 1) return sb.charAt(i);
        return '#';
    }
}
```

#### 思路二
* 先把显示一次(每一个，不包括重复)都加入队列，重复的不加入，但在对应数组累积值
* 当第一个队列对应数组的值为 1 时，即为第一个不重复的字符
```java
import java.util.*;

public class Solution {

    private int[] c;
    private Queue<Character> q;

    public Solution() {
        c = new int[256];
        q = new LinkedList<>();
    }

    public void Insert(char ch) {
        if (++c[ch] == 1) 
            q.add(ch); // 将出现一次的入队
    }

    public char FirstAppearingOnce() {
        while (!q.isEmpty() && c[q.peek()] != 1) 
            q.poll();
        if (q.isEmpty()) 
            return '#'; // 不能将这个放在上面，可能会空指针异常
        return q.peek();
    }
}
```


