## [整数中1出现的次数（从1到n整数中1出现的次数）](https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">查找</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数学</code>

#### 题目描述
> 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。

---
#### 思路
* 参考 [ZXZxin解析](https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/Other/%E5%89%91%E6%8C%87Offer/%E5%89%91%E6%8C%87Offer%20-%2031%20-%20%E6%95%B4%E6%95%B0%E4%B8%AD1%E5%87%BA%E7%8E%B0%E7%9A%84%E6%AC%A1%E6%95%B0%EF%BC%88%E4%BB%8E1%E5%88%B0n%E6%95%B4%E6%95%B0%E4%B8%AD1%E5%87%BA%E7%8E%B0%E7%9A%84%E6%AC%A1%E6%95%B0%EF%BC%89.md) 和 [yi_afly博客](https://blog.csdn.net/yi_afly/article/details/52012593)
* 比如 `5314` 中1的个数为 `((531*1+1) + (53*10+(4+1)) + (5*100+100) + (0*1000+1000))`

<img width="60%" src="./images/31_s.png">

```java 
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0)
            return 0;
        int res = 0;
        // base 当前判断的位数 
        // cur 当前位 
        // height 高位
        int base = 1, cur, height = n;
        while (height > 0) {
            cur = height % 10;
            height /= 10;
            res += height * base;
            if (cur == 1)
                res += (n % base) + 1;
            else if (cur > 1)
                res += base;
            base *= 10;
        }
        return res;
    }
}
```