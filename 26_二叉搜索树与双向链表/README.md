## [二叉搜索树与双向链表](https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">链表</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

#### 题目描述

> 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
----
> 参考 [ZXZxin解析](https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/Other/%E5%89%91%E6%8C%87Offer/%E5%89%91%E6%8C%87Offer%20-%2026%20-%20%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%8E%E5%8F%8C%E5%90%91%E9%93%BE%E8%A1%A8.md)
<img width="80%" src="./images/26_s1.png">
<img width="80%" src="./images/26_s2.png">

* 理解二叉搜索树到**排序双向链表** 之间的转换思路
* 从叶子节点改变其左右指针的指向(递归/迭代)
* 最后返回头节点 

#### 思路一(中序遍历)  
```java
import java.util.Stack;
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {// 返回排序的双向链表的头结点
        if (pRootOfTree == null)
            return null;
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null, cur = pRootOfTree, res = null;
        boolean isFirst = true;
        while (!s.isEmpty() || cur != null) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else { // 走到最左边了
                cur = s.pop();
                if (isFirst) {
                    isFirst = false;
                    res = cur;
                    pre = cur;
                } else {
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }
                cur = cur.right; //当前结点向右
            }
        }
        return res;
    }
}
```
上面中序遍历解法的递归实现
```java
public class Solution {

    private TreeNode pre;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        pre = null;
        convert(pRootOfTree); //返回的pre是双向链表的最后一个结点
        while (pre != null && pre.left != null)
            pre = pre.left;
        return pre;
    }

    private void convert(TreeNode root) {
        if (root == null)
            return;
        convert(root.left);
        root.left = pre;
        if (pre != null)
            pre.right = root;
        pre = root;
        convert(root.right);
    }
}
```
#### 思路二(后序遍历)
```java
public class Solution {

    public TreeNode Convert(TreeNode pRootOfTree) {// 返回排序的双向链表的头结点
        if (pRootOfTree == null)
            return null;
        TreeNode root = convert(pRootOfTree); //返回的还是根结点
        while (root != null && root.left != null)
            root = root.left;
        return root;  //返回最左下角那个
    }

    private TreeNode convert(TreeNode root) {
        if (root == null)
            return null;
        TreeNode L = convert(root.left);
        TreeNode R = convert(root.right);
        //将左子树的最后一个结点(最大结点)和根节点链接起来
        if (L != null) {
            while (L.right != null) {
                L = L.right;
            }
            L.right = root;
            root.left = L;
        }
        //将右子树的最小的结点和根结点链接起来
        if (R != null) {
            while (R.left != null) {
                R = R.left;
            }
            R.left = root;
            root.right = R;
        }
        return root;//返回的是链接之后的根节点
    }
}
```
<img width="80%" src="./images/26_s3.png">   

#### 思路三(最优递归)
```java
public class Solution {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        TreeNode last = convert(pRootOfTree);
        TreeNode res = last.right;//返回最右边的right(最左边的) 链表的头结点
        last.right = null;//最终设置
        return res;
    }

    //功能: 将二叉搜索树转换成一个有序的双向链表, 并返回连接之后的最后一个结点
    private TreeNode convert(TreeNode root) {
        if (root == null)
            return null;
        TreeNode endL = convert(root.left);  //左边的结尾的结点
        TreeNode endR = convert(root.right); //右边的结尾的结点
        TreeNode startL = endL != null ? endL.right : null; //左边开始的结点
        TreeNode startR = endR != null ? endR.right : null; //右边开始的结点
        //分情况连接这些结点
        if (endL != null && endR != null) {
            //连接根节点的
            root.left = endL;
            endL.right = root;
            root.right = startR;
            startR.left = root;
            //最后一个指回去
            endR.right = startL;
            return endR;
        } else if (endL != null) {//右边为空
            root.left = endL;
            endL.right = root;
            root.right = startL;
            return root;
        } else if (endR != null) {//左边为空
            root.right = startR;
            startR.left = root;
            endR.right = root;
            return endR;
        } else {  //左右都是空
            root.right = root;
            return root;
        }
    }
}
```