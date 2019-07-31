## [连续子数组的最大和](https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

> HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)

#### 思路一(递归)
* 从后往前，判断前面是否存在最大的子序列之和
* 递归边界条件 `i==0` ，此时最大子序列和为本身
```java
public class Solution {

    private int res;

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        res = array[0];
        rec(array, array.length - 1);
        return res;
    }

    private int rec(int[] arr, int i) {
        if (i == 0)
            return arr[0];
        else {
            int pre = rec(arr, i - 1);
            int cur = pre > 0 ? pre + arr[i] : arr[i];
            res = Math.max(res, cur);
            return cur;
        }
    }
}
```

#### 思路二(动态规划)
* 正向保存每一个数结尾的最大子序和，进行大小比较，循环找出最大值
```java
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int res = array[0];
        int preMax = array[0];
        for (int i = 1; i < array.length; i++) {
            preMax = preMax > 0 ? preMax + array[i] : array[i];
            res = Math.max(res, preMax);
        }
        return res;
    }
}
```