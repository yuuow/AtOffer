## [数据流中的中位数](https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">进制转化</code>

#### 题目描述

> 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。


---

#### 思路
* 很巧妙，使用大小顶推各存储 n/2 元素，然后根据情况推断计算

```java
import java.util.PriorityQueue;

public class Solution {
    //堆顶最小，但是存的是最大的 n/2个元素
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //堆顶最大，但是存的是最小的 n/2个元素
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public void Insert(Integer num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);
        if (minHeap.size() - maxHeap.size() > 1)
            maxHeap.add(minHeap.poll());
        else if (maxHeap.size() - minHeap.size() > 1)
            minHeap.add(maxHeap.poll());

    }

    public Double GetMedian() {
        if (minHeap.size() > maxHeap.size())
            return 1.0 * minHeap.peek();
        else if (maxHeap.size() > minHeap.size())
            return 1.0 * maxHeap.peek();
        else
            return 1.0 * (minHeap.peek() + maxHeap.peek()) / 2;
    }

}
```