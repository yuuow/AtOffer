## [数组中只出现一次的数字](https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述   

> 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

---

* `^` 异或
    * 任何一个数异或自身等于0，任何一个数异或0等于自身
    * 在一个数组中，如果只有一个数字出现了一次，其他出现了两次，直接全部异或一遍，最终结果就是答案
* `&` 位与
#### 思路(位运算)
* 先得到两个只出现一次的数字的异或结果，再找到结果中第一个为 1 的位的位置
* 然后以第 n 位是不是 1 为标准，把原数组中的数字分成两个子数组
* 第一个子数组中每个数字的第n 位都是 1，而第二个子数组中每个数字的第 n 位都是 0


    > 由于我们分组的标准是数字中的某一位是 1 还是 0， 那么出现了两次的数字肯定被分配到同一个子数组。因为两个相同的数字的任意一位都是相同的，我们不可能把两个相同的数字分配到两个子数组中去，于是我们已经把原数组分成了两个子数组，每个子数组都包含一个只出现一次的数字，而其他数字都出现了两次。
    
* 举例 `2, 4, 3, 6, 3, 2, 5, 5`
    * 做异或运算结果后，得到的是 2 (二进制0010)
    * 根据数字的倒数第二位是不是 1 分为两个数组，第一个子数组 `2, 3, 6, 3, 2`，第二个子数组 `4, 5, 5`
    * 分别对两个子数组求异或，第一个子数组中只出现一次的数字是 6，而第二个子数组中只出现一次的数字是 4



```java
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length < 2)
            return;
        int res = 0;
        for (int i = 0; i < array.length; i++)
            res ^= array[i];
        int digit = 1;
        while ((digit & res) == 0)
            digit *= 2;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & digit) == 0)
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }
}
```