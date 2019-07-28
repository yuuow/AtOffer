public class Solution {
    public boolean VerifySquenceOfBST1(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return rec(sequence, 0, sequence.length - 1);
    }

    public boolean rec(int[] seq, int L, int R) {
        //判断完成，满足条件
        if (L >= R)
            return true;

        int root = seq[R];
        int i = L;

        while (i < R && seq[i] < root)
            i++;
        //左右子树的分界线，注意范围 [L,mid-1] 才是左子树
        int mid = i;
        while (i < R) {
            if (seq[i] < root)
                return false;
            i++;
        }
        //左右子树重新递归判断
        return rec(seq, L, mid - 1) && rec(seq, mid, R - 1);
    }

    public boolean VerifySquenceOfBST2(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        for (int root = sequence.length - 1; root >= 0; root--) {
            int p = 0;
            while (sequence[p] < sequence[root])
                p++;
            while (sequence[p] > sequence[root])
                p++;
            if (p != root)
                return false;
        }
        return true;
    }
}