## [二叉树的深度](https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数</code>

#### 题目描述

> 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

---
#### 思路(递归)
* 当前节点的深度 = 左右子树中较高的深度 + 1
```java
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}
```

#### 思路二(非递归，使用队列)
* 当前层节点数量的统计值 `count` 与这一层节点的数量 `nextLevelSize` 相等时,总的层数 `depth++`
* 这时也可以推算出下一层结点的数量 `nextLevelSize = queue.size()`，统计值归零 `count = 0`
```java
import java.util.*;

public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0, nextLevelSize = 1, depth = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            count++;
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
            if (count == nextLevelSize) {
                count = 0;
                depth++;
                nextLevelSize = queue.size();
            }
        }
        return depth;
    }
}
```