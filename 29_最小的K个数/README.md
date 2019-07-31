## [最小的K个数](https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">高级算法</code>


#### 输出描述

> 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

---

#### 思路(大顶堆)
* PriorityQueue原理分析请参考  [堆结构的优秀实现类](https://www.jianshu.com/p/4c7ad59a0489)
* 逻辑结构是一棵完全二叉树，存储结构其实是一个数组
* 每次改变添加或者移除元素时，都会重新维持其结构
```java
import java.util.*;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length)
            return res;
        // 维护了一个最大堆(堆顶是最大的)
        PriorityQueue<Integer> maxHead = new PriorityQueue<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if ((Integer) o1 <= (Integer) o2)
                    return 1;
                else
                    return -1;
            }
        });

        for (int i = 0; i < input.length; i++) {
            if (maxHead.size() < k) {
                maxHead.add(input[i]);
            } else if (input[i] < maxHead.peek()) {
                maxHead.poll();
                maxHead.add(input[i]);
            }
        }

        for (Integer item : maxHead) {
            res.add(item);
        }
        return res;
    }
}
```
