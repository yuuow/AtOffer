## [字符串的排列](https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">字符串</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">动态规划</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">递归</code>

#### 题目描述

> 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

#### 输入描述

> 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

----
#### 思路一(经典写法)
* 每次循环将第一次交换后固定，后面序列当成一个新的序列，依次交换后面序列，即 **固定前i位，对第 i+1 位之后的再进行全排列**，递归实现
* 二次 `swap(str, cur, i);`
    * 当我们对序列进行交换之后，就将交换后的序列除去第一个元素放入到下一次递归中去了，递归完成了再进行下一次循环。这是某一次循环程序所做的工作，这里有一个问题，那就是在进入到下一次循环时，序列是被改变了。
    * 可是，如果我们要假定第一位的所有可能性的话，那么，就必须是在建立在这些序列的初始状态一致的情况下,所以每次交换后，要还原，确保初始状态一致。参考[博文](https://blog.csdn.net/lemon_tree12138/article/details/50986990) 
*  要考虑有重复字符的字符串，用`list`的`contains`方法去重，很慢。
```java
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    private ArrayList<String> res;

    public ArrayList<String> Permutation(String str) {
        res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        rec(str.toCharArray(), 0);
        Collections.sort(res);
        return res;
    }

    private void rec(char[] str, int cur) {
        if (cur == str.length - 1) {
            if (!res.contains(String.valueOf(str)))
                res.add(String.valueOf(str));
        } else {
            for (int i = cur; i < str.length; i++) {
                swap(str, cur, i);
                rec(str, cur + 1);
                swap(str, cur, i); //还原位置(保证进入下一次循环时，序列没有被改变)
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
```
#### 思路二(使用HashSet去重)
* 思路与经典一样，不过去重方式不同
```java
import java.util.*;

public class Solution {
    
    private ArrayList<String> res;

    public ArrayList<String> Permutation(String str) {
        res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        rec(str.toCharArray(), 0);
        Collections.sort(res); //也是之后排序
        return res;
    }

    //使用Set去重
    private void rec(char[] str, int cur) {
        if (cur == str.length - 1) {
            res.add(String.valueOf(str));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = cur; i < str.length; i++) {
            //重复元素就不需要交换
            if (!set.contains(str[i])) {
                set.add(str[i]);
                swap(str, cur, i);
                rec(str, cur + 1);
                swap(str, cur, i);
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
```
#### 思路三(回溯+剪枝)
* 使用 `used` 标记已经使用过的字符的位置
* 判断重复，先排序，保证重复的元素会贴在一块
    * 对与重复的元素循环时跳过递归的调用只对第一个未被使用的进行递归，那么这一次的结果将会唯一出现在结果集中，而后重复的元素将会被略过；
    * 如果第一个重复元素还没在当前结果中，那么我们就不需要进行递归。
* 记得回溯，维护`used`和`sb`

```java
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    private ArrayList<String> res;

    public ArrayList<String> Permutation(String str) {
        res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr); //保证相邻的元素在一块
        dfs(new StringBuilder(), charArr, new boolean[str.length()]);
        return res;
    }

    private void dfs(StringBuilder sb, char[] str, boolean[] used) {
        if (sb.length() == str.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if (used[i] || (i > 0 && !used[i - 1] && str[i] == str[i - 1]))//去重
                continue;
            used[i] = true;
            sb.append(str[i]);
            dfs(sb, str, used);
            used[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private void swap(char[] str, int i, int j) {
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
    }
}
```