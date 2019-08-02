## [数组中的逆序对](https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

> 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007


#### 输入描述
```
题目保证输入的数组中没有的相同的数字

数据范围：

	对于%50的数据,size<=10^4

	对于%75的数据,size<=10^5

	对于%100的数据,size<=2*10^5
```
##### 示例一

输入
```1,2,3,4,5,6,7,0```

输出
```7```

---
#### 思路
* 归并排序（切两边，再归并）解决问题，当`arr[p1] > arr[p2]`时，逆序对数量累加 `sum += (mid - p1 + 1);`（注意递归，此时前后两部分都是有序的， `p1~mid` 之间值也必定大于 `arr[p2]`,构成逆序对）
* 还有注意测试用例输出结果比较大，需要对每次的逆序对数量 `sum` 进行取模
```java
public class Solution {

    private final int mod = 1000000007;

    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1)
            return 0;
        return mergeRec(array, 0, array.length - 1);
    }

    private int mergeRec(int[] arr, int L, int R) {
        if (L == R)
            return 0;
        int mid = L + (R - L) / 2;
		return (mergeRec(arr, L, mid) + mergeRec(arr, mid + 1, R) + merge(arr, L, mid, R)) % mod;
	    //return ((merge(arr, L, mid, R) + mergeRec(arr, L, mid))%mod + mergeRec(arr, mid + 1, R))%mod; // 错误
    }

    private int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int k = 0, sum = 0;
        int p1 = L, p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            if (arr[p1] <= arr[p2])
                help[k++] = arr[p1++];
            else {
                sum += (mid - p1 + 1);
                sum %= mod;
                help[k++] = arr[p2++];
            }
        }
        while (p1 <= mid)
            help[k++] = arr[p1++];
        while (p2 <= R)
            help[k++] = arr[p2++];
        for (int i = 0; i < k; i++)
            arr[L + i] = help[i];
        return sum;
    }
}
```