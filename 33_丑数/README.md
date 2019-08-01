## [丑数](https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">穷举</code>

#### 题目描述

> 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

---

#### 思路一(穷举)

* 枚举 `Integer.MAX_VALUE` 范围内的所有丑数，打表之后排序，时间复杂度 `O(NlogN)`

```java
import java.util.*;

public class Solution {

    static ArrayList<Integer> nums;

    static {
        nums = new ArrayList<>();
        for (int a = 0; a < Integer.MAX_VALUE; a *= 2)
            for (int b = a; b < Integer.MAX_VALUE; b *= 3)
                for (int c = b; c < Integer.MAX_VALUE; c *= 5)
                    nums.add((int) c);
        Collections.sort(nums);
    }

    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 1;
        return nums.get(index - 1);
    }
}
```

#### 思路二
* 用数组存储到 `index` 位的丑值，最后直接返回第 `index` 位的值
```java
public class Solution {

    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        int[] res = new int[index + 1];
        int count = 0, i2 = 0, i3 = 0, i5 = 0;
        res[0] = 1;
        while (count < index) {
            int temp = Math.min(res[i2] * 2, Math.min(res[i3] * 3, res[i5] * 5));
            if (temp == res[i2] * 2) i2++;
            if (temp == res[i3] * 3) i3++;
            if (temp == res[i5] * 5) i5++;
            res[++count] = temp;
        }
        return res[index - 1];
    }
}
```
#### 思路三
* 用链表循环存储丑值，`peek` 获取链表的头，比对将最小值存储在变量 `candi` 
* 当计算到第 `index` 位所在丑值，直接返回 `candi`
```java
import java.util.*;

public class Solution {

    public int GetUglyNumber_Solution(int index) {
        if(index == 0)
            return 0;
        Queue<Integer> q2 = new LinkedList<>(), q3 = new LinkedList<>(), q5 = new LinkedList<>();
        int candi = 1, cnt = 1;
        while(cnt < index){ 
            q2.add(candi * 2); 
            q3.add(candi * 3);  
            q5.add(candi * 5);
            int min = Math.min(q2.peek(), Math.min(q3.peek(), q5.peek()));
            if(q2.peek() == min) q2.poll();
            if(q3.peek() == min) q3.poll();
            if(q5.peek() == min) q5.poll();
            candi = min;
            cnt++;
        }
        return candi;
    }
}
```
