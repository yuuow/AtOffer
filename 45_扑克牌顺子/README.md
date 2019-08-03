## [扑克牌顺子](https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">字符串</code>

#### 题目描述

> LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
---
#### 思路一
* 是否存在足够的零，去补充相邻数字间的空缺
* 先将数组排序，统计零的个数，然后累加数组相邻数字间的空缺值（跳过零），最后与零的个数进行比对
```java
import java.util.Arrays;
public class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5)
            return false;
        Arrays.sort(numbers);
        int interval = 0, zero = 0;
        for (int i = 0; i < 4; i++) {
            //判断零的个数，numbers[4]不需要判断
            if (numbers[i] == 0) {
                zero++;
                continue;
            }
            if (numbers[i] == numbers[i + 1])
                return false;
            interval += numbers[i + 1] - numbers[i] - 1;
        }
        return zero >= interval;
    }
}
```

#### 思路二
* 最大的数字到最小的数字距离要小于5（且不能重复）
* 使用位操作判断重复数字(根据位数来表示数字)
    * `|` 位或  `bit |= (1 << num)`  用位数表示数字
    * `&` 位与  `((bit >> num) & 1) != 0` 相同数字位于为1
```java
public class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5)
            return false;
        int max = -1, min = 14;
        int bit = 0;
        for (int num : numbers) {
            if (num > 13 || num < 0)
                return false;
            if (num == 0)
                continue;
            if (((bit >> num) & 1) != 0)
                return false;
            bit |= (1 << num);
            if (num > max)
                max = num;
            if (num < min)
                min = num;
            if ((max - min) > 5)
                return false;
        }
        return true;
    }
}
```