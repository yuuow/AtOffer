## [二进制中1的个数](https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">查找</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

> 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

---

> 参考 [ZXBlog解析](https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/Other/%E5%89%91%E6%8C%87Offer/%E5%89%91%E6%8C%87Offer%20-%2011%20-%20%E4%BA%8C%E8%BF%9B%E5%88%B6%E4%B8%AD1%E7%9A%84%E4%B8%AA%E6%95%B0.md)
* 考察相关位运算
* 左移运算符 `<<` 与 右移运算符 `>>` 的运用
    * 左移运算符 `m << n` 表示把 `m` 左移`n` 位。左移 `n` 位的时候，最左边的 `n` 位将被丢弃，同时在最右边补上 `n` 个 0。
    ```
    00001010 << 2 = 00101000
    10001010 << 3 = 01010000   
    ```
    * 右移运算符
        * 如果数字是一个无符号数值，则用 0 填补最左边的 n 位。
        * 如果数字是一个有符号数值，则用数字的符号位填补最左边的n位。  
    * 即**如果数字原先是一个正数，则右移之后在最左边补n个 0；如果数字原先是负数，则右移之后在最左边补n个1。**
    ```
    00001010 >> 2= 00000010
    10001010 >> 3 = 11110001 // 负
    ```
#### 思路一(不能处理负数-wrong answer)
* 每次将 `n` 右移一位· 移动后最后一位与 1 做运算，统计 1 的个数
* 不能处理负数，因为负数右移在左边补1，会陷入死循环
```java
public class Solution {
    public int NumberOf1(int n) {
        int sum = 0;
        // while (n != 0) {
        while (n > 0) {
            if ((n & 1) != 0)
                sum++;
            n >>= 1;
        }
        return sum;
    }
}
```
#### 思路二
* 引入另一个变量 `another = 1` ，每次将 `another` 左移一位，然后与 `n` 做运算，判断 `n` 的每一位是不是 1，统计 1 的个数
* 注意条件 `another != 0`，当 `another` 也就是 1，左移32次后，会溢出，值为0。(int的取值范围 `-2的31次方到2的31次方-1`)
```java
public class Solution {
    public int NumberOf1(int n) {
        int sum = 0;
        int another = 1;
        while (anthor != 0) {
            if ((n & another) != 0)
                sum++;
            another <<= 1;
        }
        return sum;
    }
}
```
#### 思路三(最优解)
* 一个数和比自己小1的数做与运算，会把这个数最右边的1变成0；
* 然后看能做几次这样的运算，这个数就有多少个1；
* 这个方法有多少个1，就只需要循环多少次，是最优解法；
> 如果一个整数不等于0，那么该整数的二进制表示中至少有一位是 1。先假设这个数的最右边一位是 1，那么减去 1 时，最后一位变成 0 而其他所有位都保持不变。也就是最后一位相当于做了取反操作，由 1 变成了 0。  
> 
> 接下来假设最后一位不是 1 而是 0 的情况。如果该整数的二进制表示中最右边 1 位于第 m 位，那么减去1时，第m 位由1 变成0，而第 m 位之后的所有 0 都变成 1整数中第 m 位之前的所有位都保持不变。举个例子，一个二进制数 1100，它的第二位是从最右边数起的一个 1。减去 1 后，第二位变成0，它后面的两位 0 变成 1，而前面的 1 保持不变，因此得到的结果是 1011。
> 
> 在前面两种情况中, 我们发现把一个整数减去 1，都是把最右边的 1 变成0。如果它的右边还有 0 的话，所有的 0 都变成 1，而它左边所有位都保持不变。接下来我们把一个整数和它减去 1 的结果做位与运算，相当于把它最右边的 1 变成 0。还是以前面的 1100 为例，它减去 1 的结果是 1011。我们再把 1100和 1011 做位与运算，得到的结果是 1000。我们把 1100 最右边的 1 变成了0，结果刚好就是 1000。
> 
> 总结: **把一个整数减去 1 再和原整数做与运算，会把该整数最右边一个 1 变成 0。那么一个整数的二进制表示中有多少个 1，就可以进行多少次这样的操作。**
```java
public class Solution {
    public int NumberOf1(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }
}
```