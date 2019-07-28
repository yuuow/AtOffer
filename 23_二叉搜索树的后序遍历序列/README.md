## [二叉搜索树的后序遍历序列](https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd)

<code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">栈</code><span>&nbsp;</span>|<span>&nbsp;</span><code style="color: var(--vscode-textPreformat-foreground); font-family: Menlo, Monaco, Consolas, &quot;Droid Sans Mono&quot;, &quot;Courier New&quot;, monospace, &quot;Droid Sans Fallback&quot;; font-size: 14px; line-height: 19px;">树</code>

#### 题目描述
> 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

---
* 二叉搜索树

  > 一棵空树或者具有下列性质的二叉树： 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值； 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值； 任意节点的左、右子树也分别为二叉查找树； 没有键值相等的节点。
* 后序遍历数组成员可划分成三个部分：最后一个数就是树根节点的值 `root`
* 左边是左子树节点的值，且都小于 `root` ；右边是柚子树结点的值，且都大于 `root`（二叉搜索树的定义推断）
#### 思路一(递归)
* 每次先确定根节点的值 `root`，然后根据左子树的值都小于`root`，在`[L,R]`中确定 `mid`
* 如果在 `mid` 后右子树有值小于 `root`，则返回 `false`
```java
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return rec(sequence, 0, sequence.length - 1);
    }

    public boolean rec(int[] seq, int L, int R) {
        if (L >= R)
            return true;
        int root = seq[R];
        int i = L;

        while (i < R && seq[i] < root)
            i++;
        int mid = i;
        while (i < R) {
            if (seq[i] < root)
                return false;
            i++;
        }
        return rec(seq, L, mid - 1) && rec(seq, mid, R - 1);
    }
}
```
#### 思路二(非递归)
* **将每一个数都看做某一棵子树的根**，然后判断这颗子树条件(左边是<`root`，右边是>`root`)；
* 重复判断了一些情况，效率不高
```java
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        for(int root = sequence.length - 1; root >= 0; root--){
            int p = 0;
            while(sequence[p] < sequence[root]) p++;
            while(sequence[p] > sequence[root]) p++;
            if(p != root)
                return false;
        }
        return true;
    }
}
```