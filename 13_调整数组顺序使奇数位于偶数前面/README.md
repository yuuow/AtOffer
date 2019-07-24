## [调整数组顺序使奇数位于偶数前面](https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

>输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

---
* 难点注意：**偶数和偶数之间的相对位置不变**
#### 思路一(类似冒泡排序)
```java
public class Solution {
    public void reOrderArray(int[] array) { 
        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                //如果此时前后分别为偶数和奇数，交换位置（保持相对位置不发生改变）
                if (!odd(arry[i]) && odd(array[i + 1])) {
                    int t = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = t;
                }
            }
        }
    }

    public boolean odd(int n) {
        return (n & 1) == 1 ? true : false;
    }
}
```
#### 思路二(类似插入排序)
* 简单粗暴，依次找到第一个偶数，相对的第一个奇数，然后整体交换位置
```java
public class Solution {
    public void reOrderArray(int[] array) {
        int L = 0, R;
        while (L < array.length) {
            while (L < array.length && odd(array[L])) //找到第一个偶数
                L++;
            R = L + 1;
            while (R < array.length && !odd(array[R])) //从 L 后面找到第一个奇数 
                R++;
            // 此时arr[L]是偶数　　arr[R]是奇数　
            // -->将 [L,..R-1]中的数　整体向后移动一个位置
            if (R < array.length) {
                int t = array[R];
                for (int i = R - 1; i >= L; i--)
                    array[i + 1] = array[i];
                array[L] = t;
                // L 和 R 此时都已经交换了位置
                L++;
            } else {
                break;
            }

        }
    }

    public boolean odd(int n) {
        return (n & 1) == 1 ? true : false;
    }
}
```