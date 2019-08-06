## [对称的二叉树](https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

#### 题目描述

> 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。


----

#### 思路一
* 递归调用，注意左右结点的值要想等，节点之间的对称关系

```java
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null ? true : mirror(pRoot.left, pRoot.right);
    }

    private boolean mirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return left.val == right.val && mirror(left.left, right.right) && mirror(left.right, right.left);
    }
}
```

#### 思路二(非递归)
* 层次遍历，使用容器实现，要成对取出

使用队列
```java
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot.left);
        queue.add(pRoot.right);
        while (!queue.isEmpty()) {
            TreeNode right = queue.poll();
            TreeNode left = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            //成对插入
            queue.add(left.left); queue.add(right.right);
            queue.add(left.right); queue.add(right.left);
        }
        return true;
    }
}
```
使用栈
```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while (!s.isEmpty()) {
            TreeNode right = s.pop();
            TreeNode left = s.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            //成对插入
            s.push(left.left); s.push(right.right);
            s.push(left.right); s.push(right.left);
        }
        return true;
    }
}
```
