## [按之字形顺序打印二叉树](https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">栈</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

#### 题目描述

> 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

#### 思路一(非递归)
* 使用额外的布尔变量 `ok` 确定是否翻转
* 每次遍历容器 `queue.size()` ，来存储不同层数 

```java
import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;

        boolean ok = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            if (ok)
                Collections.reverse(tmp);
            ok = !ok;
            res.add(tmp);
        }
        return res;
    }
}
```

#### 思路二(递归)
* 通过下标的奇偶判断是否需要翻转
* 通过树的深度 `level` 判断，来存储不同层数

```java
import java.util.*;
public class Solution {
    
    ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        res = new ArrayList<>();
        rec(pRoot, 0);
        for(int i = 0; i < res.size(); i++) 
            if( i % 2 == 1) 
                Collections.reverse(res.get(i));
        return res;
    }
    
    private void rec(TreeNode node, int level){
        if(node == null) 
            return;
        if(level >= res.size()){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(node.val);
            res.add(tmp);
        }else {
            res.get(level).add(node.val);
        }
        rec(node.left, level+1);
        rec(node.right, level+1);
    }
}
```
