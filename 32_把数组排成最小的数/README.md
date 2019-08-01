## [把数组排成最小的数](https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数组</code>

#### 题目描述

> 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

----

#### 思路
* 关键在于排序规则，注意String类的 `compareTo` 方法
    > 返回值是整型，它是先比较对应字符的大小(ASCII码顺序)，如果第一个字符和参数的第一个字符不等，结束比较，返回他们之间的差值，如果第一个字符和参数的第一个字符相等，则以第二个字符和参数的第二个字符做比较，以此类推,直至比较的字符或被比较的字符有一方结束。
* `Comparator` 和 `Comparable` 两种比较器的区别
    > Comparable & Comparator接口都可以用来实现集合中元素的比较、排序，Comparator位于包java.util下，而Comparable位于包java.lang下，Comparable接口将比较代码嵌入自身类中，而后者在一个独立的类中实现比较。像Integer、String等这些基本类型的JAVA封装类都已经实现了Comparable接口，这些类对象本身就支持自比较，直接调用Collections.sort()就可以对集合中元素的排序，无需自己去实现Comparable接口。而有些自定义类的List序列，当这个对象不支持自比较或者自比较函数不能满足你的要求时，你可以写一个比较器来完成两个对象之间大小的比较，也就是指定使用Comparator（临时规则排序，也称作专门规则排序），如果不指定Comparator，那么就用自然规则排序，这里的自然顺序就是实现Comparable接口设定的排序方式。
* `Comparator` 中 `Lambda表达式` 的使用
```java
import java.util.*;

public class Solution {
    public String PrintMinNumber(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
            list.add(numbers[i] + "");
        Collections.sort(list, (o1, o2) -> ((o1 + o2).compareTo(o2 + o1)));
        StringBuffer sb = new StringBuffer();
        for (String s : list)
            sb.append(s);
        return sb.toString();
    }
}
```
