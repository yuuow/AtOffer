## [和为S的连续正数序列](https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">穷举</code>

#### 题目描述

> 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

#### 输出描述

> 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

---
#### 思路(快慢指针)
* 两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
```java
import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int pLow = 1, pHight = 2;
        while (pHight > pLow) {

            //连续序列之和 (a1+an)*n/2
            int cur = (pHight + pLow) * (pHight - pLow + 1) / 2;

            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = pLow; i <= pHight; i++)
                    list.add(i);
                res.add(list);
                pLow++;
            } else if (cur < sum) {
                pHight++;
            } else {
                pLow++;
            }
        }
        return res;
    }

}
```
