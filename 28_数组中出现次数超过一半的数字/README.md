## [数组中出现次数超过一半的数字](https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

> 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
---
#### 思路一(使用map保存次数)
* `map.getOrDefault(key,defaultValue)` 当 `Map` 集合中包含这个 `key` 时，就使用这个 `key` 对应的 `value` 值；如果没有，就使用默认值  `defaultValue`。

```java
import java.util.HashMap;

public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            if (map.get(array[i]) > array.length / 2)
                return array[i];
        }
        return 0;
    }
}
```

#### 思路二(摩尔投票)
* 变量 `candi` 为候选，`times` 为次数
* 如果一个数出现次数大于一半，则这个数最后一定会被剩下来，也就是最后的 candi 值
* 比如 ` 1 2 1` 剩下为 1，符合；`1 2 3` 剩下为 3,不符合，需要校验
```java
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0 || array == null)
            return 0;
        if (array.length == 1)
            return array[0];
        int candi = 0, times = 0;
        for (int i = 0; i < array.length; i++) {
            if (times == 0) {
                candi = array[i];
                times = 1;
            } else if (array[i] == candi) {//又遇到一个同样的，累加
                times++;
            } else {// times != 0 && array[i] != res
                times--;
            }
        }
        // 最后一定要检验，不一定就是res
        times = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] == candi)
                times++;
        if (times * 2 > array.length)
            return candi;
        return 0;
    }
}
```
