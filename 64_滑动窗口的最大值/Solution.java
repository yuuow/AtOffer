import java.util.*;

public class Solution {
    //单调双向队列(窗口内最大值)
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || size < 1 || num.length < size)
            return res;
        //保存的是下标
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            //要队尾满足条件
            //如果尾部小于要填加的值，移除尾部(头部最大)
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i])
                qmax.pollLast();
            //尾部必须比添加的值大
            qmax.addLast(i);
            //向左弹出  过期的数据s
            if (i - size == qmax.peekFirst())
                qmax.pollFirst();
            if (i >= size - 1)
                res.add(num[qmax.peekFirst()]);
        }
        return res;
    }
}
//{2,3,4,2,6,2,5,1}