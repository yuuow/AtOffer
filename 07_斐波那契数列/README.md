## [斐波那契数列](https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">递归</code>

#### 题目描述

> 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39

-----
**几个要点**：
* 在数学上，费波那契数列是以递归的方法来定义：`F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2）`
* 首几个费波那契系数是：`0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233……`
* `0` 不是第一项，而是第零项
> 参考 [ZXZxin解析](https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/Other/%E5%89%91%E6%8C%87Offer/%E5%89%91%E6%8C%87Offer%20-%2007%20-%20%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%97.md)
#### 思路一(递归)
```java
public class Solution {
    public int Fibonacci(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
```
#### 思路二(记忆化，本质还是递归)
```java
public class Solution {

    public int[] dp;

    public int Fibonacci(int n) {
        dp = new int[n + 1];
        return rec(n);
    }

    public int rec(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (dp[n] != 0)
            return dp[n];
        dp[n] = rec(n - 1) + rec(n - 2);
        return dp[n];
    }
}
```
#### 思路三(递推(DP))
```java
public class Solution {
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```
#### 思路四(滚动优化)
> `dp[i]`只依赖于`dp[i-1]`和`dp[i-2]`，所以用`f1`、`f2`两个变量即可。
```java
public class Solution {
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int f1 = 0;
        int f2 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }
}
```
#### 思路五(利用矩阵快速幂)(较复杂，不太理解)
> 矩阵操作 参考 [博客一](https://blog.csdn.net/zxzxzx0119/article/details/82822588) / [博客二](https://blog.csdn.net/zxzxzx0119/article/details/82816131)
<img src="./images/07.png"/>

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

    public int Fibonacci(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        Matrix a = new Matrix(2, 2);
        a.m[0][0] = a.m[0][1] = a.m[1][0] = 1;
        a.m[1][1] = 0;
        Matrix res = pow(a, n - 2); //此时列向量是 F1 = 1, F2 = 1
        return res.m[0][0] + res.m[0][1];
    }
}
````