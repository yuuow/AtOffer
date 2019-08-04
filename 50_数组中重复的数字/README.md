## [数组中重复的数字](https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8)


<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

> 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

---
#### 思路一
* 使用数组记录已经访问过的数字
```java
public class Solution {
    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0)
            return false;
        boolean[] used = new boolean[length];
        for (int num : numbers) {
            if (used[num]) {
                duplication[0] = num;
                return true;
            }
            used[num] = true;
        }
        return false;
    }
}
```

#### 思路二
* 数字都在 `0 \~ n-1` 之间，可以每次将访问到的数字以其为坐标 `int index = Math.abs(numbers[i]);`，对应数组中的位置取反 `numbers[index] = -numbers[index];`，当访问到负数时，即为重复值
```java
public class Solution {
    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0)
            return false;
        for (int i = 0; i < length; i++) {
            int index = Math.abs(numbers[i]);
            if (numbers[index] >= 0)
                numbers[index] = -numbers[index];
            else {
                duplication[0] = index;
                return true;
            }
        }
        return false;
    }
}
```