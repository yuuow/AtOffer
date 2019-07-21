## [跳台阶](https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">递归</code>

#### 题目描述

> 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

---
> 参考[上一题](../07_斐波那契数列)，基本一模一样..

#### 思路一(递归)
```java
public class Solution {
    public int JumpFloor1(int target) {
        if (target < 1)
            return 0;
        //很巧妙，直接返回本来值就行，2333..
        if (target == 1 || target == 2)
            return target;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
```
#### 思路二(记忆化)
```java
public class Solution {
    public int[] dp;

    public int JumpFloor(int target) {
        dp = new int[target + 1];
        return rec(target);
    }

    public int rec(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        dp[target] = rec(target - 1) + rec(target - 2);
        return dp[target];
    }
}
```
#### 思路三(递推(DP))
```java
public class Solution {
    public int JumpFloor(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
```
#### 思路四(滚动优化)
```java
public class Solution {
    public int JumpFloor(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        int f1 = 1;
        int f2 = 2;
        int res = 0;
        //从特殊用例开始滚动..
        for (int i = 3; i <= target; i++) {
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }
}
```
#### 思路五(利用矩阵快速幂)
> 参考[上题](../07_斐波那契数列/README.md#思路五(利用矩阵快速幂)(较复杂，不太理解))...  
> 注意返回时return res.m[0][0] * 2 + res.m[0][1]; 
```java
public class Solution {

    static class Matrix {
        public int row;
        public int col;
        public int[][] m;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
            m = new int[row][col];
        }
    }

    static Matrix mul(Matrix a, Matrix b) {
        Matrix c = new Matrix(a.row, b.col); //注意这里

        for (int i = 0; i < a.row; i++) {
            for (int j = 0; j < b.col; j++) {
                for (int k = 0; k < a.col; k++)
                    c.m[i][j] = c.m[i][j] + a.m[i][k] * b.m[k][j];
            }
        }
        return c;
    }

    static Matrix pow(Matrix a, int k) {
        Matrix res = new Matrix(a.row, a.col); // 方阵
        for (int i = 0; i < a.row; i++)
            res.m[i][i] = 1;
        while (k > 0) {
            if ((k & 1) != 0)
                res = mul(res, a);
            a = mul(a, a);
            k >>= 1;
        }
        return res;
    }

    public int JumpFloor(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        Matrix a = new Matrix(2, 2);
        a.m[0][0] = a.m[0][1] = a.m[1][0] = 1;
        a.m[1][1] = 0;
        Matrix res = pow(a, target - 2);

        //注意这里F2 = 2 ,所以乘以2
        return res.m[0][0] * 2 + res.m[0][1]; 
    }
}
```