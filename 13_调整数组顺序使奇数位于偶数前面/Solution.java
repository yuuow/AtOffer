public class Solution {
    // 方法一 冒泡排序
    public void reOrderArray1(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (!odd(arry[i]) && odd(array[i + 1])) {
                    int t = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = t;
                }
            }
        }
    }

    // 方法二 插入排序
    public void reOrderArray2(int[] array) {
        int L = 0, R;
        while (L < array.length) {
            while (L < array.length && odd(array[L])) //找到第一个偶数
                L++;
            R = L + 1;
            while (R < array.length && !odd(array[R])) //从L后面找到第一个奇数 
                R++;
            // 此时arr[L]是偶数　　arr[R]是奇数　
            // -->将 [L,..R-1]中的数　向后移动一个位置
            if (R < array.length) {
                int t = array[R];
                for (int i = R - 1; i >= L; i--)
                    array[i + 1] = array[i];
                array[L] = t;
                L++;
            } else {
                break;
            }

        }
    }

    //判断是否为奇数
    public boolean odd(int n) {
        return (n & 1) == 1 ? true : false;
    }
}