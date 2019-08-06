## [把二叉树打印成多行](https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">栈</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

#### 题目描述

> 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

---
#### 思路一(非递归)

```java
import java.util.*;

public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while(!queue.isEmpty()){
            int n = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }
}
```

#### 思路二(递归)
```java
import java.util.*;

public class Solution {

    ArrayList<ArrayList<Integer>> res;

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        res = new ArrayList<>();
        rec(pRoot, 0);
        return res;
    }

    private void rec(TreeNode node, int level) {
        if (node == null) return;
        if (res.size() <= level) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(node.val);
            res.add(tmp);
        } else {
            res.get(level).add(node.val);
        }
        rec(node.left, level + 1);
        rec(node.right, level + 1);
    }
}
Terms
```