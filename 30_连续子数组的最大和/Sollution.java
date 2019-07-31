public class Solution {

    //方法一 递归
    private int res;

    public int FindGreatestSumOfSubArray1(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        res = array[0];
        rec(array, array.length - 1);
        return res;
    }

    private int rec(int[] arr, int i) {
        if (i == 0)
            return arr[0];
        else {
            int pre = rec(arr, i - 1);
            int cur = pre > 0 ? pre + arr[i] : arr[i];
            res = Math.max(res, cur);
            return cur;
        }
    }

    //方法二 动态规划
    public int FindGreatestSumOfSubArray2(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int[] ends = new int[array.length];
        ends[0] = array[0];
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            ends[i] = ends[i - 1] > 0 ? ends[i - 1] + array[i] : array[i];
            res = Math.max(res, ends[i]);
        }
        return res;
    }

    //上一思路的另类实现
    public int FindGreatestSumOfSubArray3(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int res = array[0];
        int preMax = array[0];
        for (int i = 1; i < array.length; i++) {
            preMax = preMax > 0 ? preMax + array[i] : array[i];
            res = Math.max(res, preMax);
        }
        return res;
    }
}