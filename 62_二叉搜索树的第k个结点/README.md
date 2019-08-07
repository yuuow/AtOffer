## [二叉搜索树的第k个结点](https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">栈</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

#### 题目描述

> 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。


----

#### 思路一
* 二叉搜索树的中序遍历是升序的，直接中序遍历计数求值
```java
import java.util.*;

public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRoot;
        int cnt = 0;
        while(!stack.isEmpty() || p != null){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            cnt++;
            if(k == cnt) 
                return p;
            p = p.right;
        }
        return null;
    }
}
```

#### 思路二(递归,难理解)
* 先走到最左边，最下面如果没有到达 k，就直接返回 null，即可，只有在 `k == cnt` 的时候，才会返回找到的节点。
* `L != null`,当到达 k 才不为 null,返回 L

```java
import java.util.*;

public class Solution {
    int cnt;
    
    TreeNode KthNode(TreeNode pRoot, int k) {
        return in(pRoot, k);
    }
    
    private TreeNode in(TreeNode node, int k) {
        if (node == null) 
            return null;
        TreeNode L = in(node.left, k);
        if (L != null) 
            return L;//之前已经找到了
        return ++cnt == k ? node : in(node.right, k);
    }
}
```