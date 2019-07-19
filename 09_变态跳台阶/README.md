## [变态跳台阶](https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">贪心</code>

#### 题目描述

> 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

---
* 第n个台阶可以从前面所有的台阶跳过来，别忘记，还可以直接跳到自己所在的台阶(+1)。`f[n] = f[n-1] + f[n-2] + ... f[1] + 1`,
#### 思路一(递归)
```java
public class Solution {
    public int JumpFloorII(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        int sum = 1;
        for (int i = 1; i < target; i++) {
            sum += JumpFloorII(i);
        }
        return sum;
    }
}
```
#### 思路二(递推(DP))
```java
public class Solution {
    public int JumpFloorII(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        int preSum = 3;
        for (int i = 3; i <= target; i++) {
            dp[i] = preSum + 1;
            preSum += dp[i];
        }
        return dp[target];
    }
}
```
#### 思路三(滚动优化)
```java
public class Solution {
    public int JumpFloorII(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        int preSum = 3, res = 0;//一开始  preSum = f1 + f2的值
        for (int i = 3; i <= target; i++) {
            res = preSum + 1;  //之前的和　加上自己的
            preSum += res;
        }
        return res;
    }
}
```
#### 思路四(找规律)
> 一个等比数列求和** ，也就是2<sup>n-1</sup>
```java
public class Solution {
    
//    public int JumpFloorII(int target) {
//        return (int) Math.pow(2, target - 1);
//    }

    public int JumpFloorII(int target) {
        return 1 << (target - 1);
    }
}
```