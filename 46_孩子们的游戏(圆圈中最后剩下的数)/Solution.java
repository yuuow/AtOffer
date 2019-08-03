import java.util.LinkedList;

public class Solution {
    //方法一
    public int LastRemaining_Solution1(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }

    //方法二
    public int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        if (n == 1)
            return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }

}