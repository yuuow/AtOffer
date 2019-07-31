import java.util.HashMap;

public class Solution {
    //方法一 
    public int MoreThanHalfNum_Solution1(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            if (map.get(array[i]) > array.length / 2)
                return array[i];
        }
        return 0;
    }

    //方法二
    public int MoreThanHalfNum_Solution2(int[] array) {
        if (array.length == 0 || array == null)
            return 0;
        if (array.length == 1)
            return array[0];
        int candi = 0, times = 0;
        for (int i = 0; i < array.length; i++) {
            if (times == 0) {
                candi = array[i];
                times = 1;
            } else if (array[i] == candi) {//又遇到一个同样的，累加
                times++;
            } else {// times != 0 && array[i] != res
                times--;
            }
        }
        // 最后一定要检验，不一定就是res
        times = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] == candi)
                times++;
        if (times * 2 > array.length)
            return candi;
        return 0;
    }
}
