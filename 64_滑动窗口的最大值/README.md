## [滑动窗口的最大值](https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

> 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

---

#### 思路(单调双向队列)
* `while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i])` 当尾部元素小于要填加的值，移除尾部（直到添加的值小于尾部或者 `qmax` 为空），可以推断头部一直都是最大值的下标
* `i - size == qmax.peekFirst()` ，头部过期，移除头部
* `i >= size - 1`，满足条件，添加此时滑动窗口里数值的最大值

```java
import java.util.*;

public class Solution {
    //单调双向队列(窗口内最大值)
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || size < 1 || num.length < size)
            return res;
        //保存的是下标
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            //要队尾满足条件
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i])
                qmax.pollLast();
            qmax.addLast(i);
            //向左弹出  过期的数据s
            if (i - size == qmax.peekFirst())
                qmax.pollFirst();
            if (i >= size - 1)
                res.add(num[qmax.peekFirst()]);
        }
        return res;
    }
}
```