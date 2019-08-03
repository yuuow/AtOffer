## [和为S的两个数字](https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数学</code>

#### 题目描述

> 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

#### 输出描述

> 对应每个测试案例，输出两个数，小的先输出。

#### 思路
* **当 `L` 与 `R` 隔得越远，乘积越小**，直接使用快慢指针排序查找
```java
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int L = 0, R = array.length - 1;
        while (L < R) {
            if (array[L] + array[R] > sum)
                R--;
            else if (array[L] + array[R] < sum)
                L++;
            else {
                res.add(array[L]);
                res.add(array[R]);
                return res;
            }
        }
        return res;
    }
}
```