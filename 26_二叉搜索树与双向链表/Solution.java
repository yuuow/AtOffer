import java.util.Stack;

public class Solution {
    //方法一 中序遍历(非递归)
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null, cur = pRootOfTree, res = null;
        boolean isFirst = true;
        while (!s.isEmpty() || cur != null) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                //cur == null s不为空
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
                cur = cur.right;
            }
        }
        return res;
    }

    //方法一 中序遍历(递归)
    private TreeNode pre;

    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        pre = null;
        convert2(pRootOfTree);
        while (pre != null && pre.left != null)
            pre = pre.left;
        return pre;
    }

    private void convert2(TreeNode root) {
        if (root == null)
            return;
        convert2(root.left);
        root.left = pre;
        if (pre != null)
            pre.right = root;
        pre = root;
        convert2(root.right);
    }

    // 方法二 后序遍历
    public TreeNode Convert3(TreeNode pRootOfTree) {// 返回排序的双向链表的头结点
        if (pRootOfTree == null)
            return null;
        TreeNode root = convert3(pRootOfTree); //返回的还是根结点
        while (root != null && root.left != null)
            root = root.left;
        return root; //返回最左下角那个
    }

    private TreeNode convert3(TreeNode root) {
        if (root == null)
            return null;
        TreeNode L = convert3(root.left);
        TreeNode R = convert3(root.right);
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

    //方法三 最优递归
    public TreeNode Convert4(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        TreeNode last = convert4(pRootOfTree);
        TreeNode res = last.right;//返回最右边的right(最左边的) 链表的头结点
        last.right = null;//最终设置(双向链表前后节点指向空)
        return res;
    }

    //功能: 将二叉搜索树转换成一个有序的双向链表, 并返回连接之后的最后一个结点
    private TreeNode convert4(TreeNode root) {
        if (root == null)
            return null;
        TreeNode endL = convert4(root.left); //左边的结尾的结点
        TreeNode endR = convert4(root.right); //右边的结尾的结点
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
        } else { //左右都是空
            root.right = root;
            return root;
        }
    }
}
