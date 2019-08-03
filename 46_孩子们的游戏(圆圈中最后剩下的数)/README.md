## [孩子们的游戏(圆圈中最后剩下的数)](https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">链表</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数学</code>

#### 题目描述

> 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

---
* **约瑟夫环 递推公式  `f(N,M)=(f(N−1,M)+M)%N`**
    > 每删除掉一个节点，下一个节点成为头，相当于把数组向前移动M位。若已知 N-1 个人时，胜利者的下标位置位 `f(N−1,M)`，则N个人的时候，就是往后移动M为，(因为有可能数组越界，超过的部分会被接到头上，所以还要模N)，既 `f(N,M)=(f(N−1,M)+M)%N`
#### 思路
* 链表移除，直到最后一个
```java
import java.util.LinkedList;

public class Solution {
    
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }

}
```

#### 思路二
* 递推公式
    * `f[1]=0;`
    * `f[i]=(f[i-1]+m)%i;  (i>1)`
```java
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        if (n == 1)
            return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
}
```