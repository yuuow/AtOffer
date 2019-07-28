## [二叉树中和为某一值的路径](https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">数</code>

#### 题目描述

> 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

----

#### 思路(递归)
* 注意 `path` 要回溯，每一轮递归返回到父结点时，当前路径也应该回退一个结点


```java
import java.util.ArrayList;

public class Solution {

    private ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        res = new ArrayList<>();
        if (root == null)
            return res;
        ArrayList<Integer> path = new ArrayList<>();
        rec(root, 0, target, path);
        return res;
    }

    private void rec(TreeNode node, int curSum, int target, ArrayList<Integer> path) {
        if (node == null)
            return;
        curSum += node.val;
        path.add(node.val);
        if (curSum == target && node.left == null && node.right == null)
            res.add(new ArrayList<>(path));
        rec(node.left, curSum, target, path); 
        rec(node.right, curSum, target, path);

        path.remove(path.size() - 1);
    }
}
```
