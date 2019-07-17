## [替换空格](https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">字符串</code>

#### 题目描述

> 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

----
#### 思路(从后往前插入)
* 首先计算出空格的个数，得到新的字符串的长度
* (循环)然后从原来的字符串末尾进行检查，在新的末尾进行扩充操作
* 最后退出，得到最终结果

#### 代码
```java
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	int spaceNums = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)==' ')
                spaceNums++;
        }
        int oldLength = str.length()-1;
        int newLength = str.length() + 2*spaceNums -1;
        str.setLength(newLength+1);
        while(oldLength>0) {
            if(str.charAt(oldLength)==' ') {
                str.setCharAt(newLength--,'0'); 
                str.setCharAt(newLength--,'2');
                str.setCharAt(newLength--,'%');
            } else{
                str.setCharAt(newLength--,str.charAt(oldLength));
            }
            oldLength--;
        }
        return str.toString();
    }
}
```

