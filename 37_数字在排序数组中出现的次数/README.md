## [数字在排序数组中出现的次数](https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

> 统计一个数字在排序数组中出现的次数。

---
#### 思路(非递归)
```java
public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int L = firstEqual(array, k);
        int R = lastEqual(array, k);
        if (L != -1 && R != -1)
            return R - L + 1;
        return 0;
    }

    //找到第一个key
    private int firstEqual(int[] arr, int key) {
        int L = 0, R = arr.length - 1;
        int mid;
        while (L <= R) {
            mid = L + (R - L) / 2;
            if (arr[mid] >= key)
                R = mid - 1;
            else
                L = mid + 1;
        }
        if (L <= arr.length - 1 && arr[L] == key)
            return L;
        return -1;
    }

    //找到最后一个key
    private int lastEqual(int[] arr, int key) {
        int L = 0, R = arr.length - 1;
        int mid;
        while (L <= R) {
            mid = L + (R - L) / 2;
            if (arr[mid] <= key)
                L = mid + 1;
            else
                R = mid - 1;
        }
        if (R >= 0 && arr[R] == key)
            return R;
        return -1;
    }
}
```