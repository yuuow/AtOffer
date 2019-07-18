import java.util.ArrayList;

public class Solution {
    public int minNumberInRotateArray1(int[] array) {
        if (array.length == 0)
            return 0;
        int L = 0, R = array.length - 1;
        //确保是旋转数组
        while (array[L] >= array[R]) {
            // 分界点
            if (R - L == 1)
                return array[R];
            int mid = L + (R - L) / 2;
            //｛1，0，1，1，1｝ 和 ｛1，1， 1，0，1｝ 
            // rotateArray[left] rotateArray[right] rotateArray[mid]三者相等
            // 重复元素的特殊情况  不能确定中间元素是属于前面还是后面的递增子数组
            // 只能顺序查找
            if (array[L] == array[mid] && array[mid] == array[R]) {
                for (int i = L + 1; i <= R; i++)
                    if (array[i] < array[i - 1])
                        return array[i];
            }
            //中间元素位于前面的递增子数组
            //此时最小元素位于中间元素的后面
            if (array[mid] >= array[L])
                L = mid;
            //中间元素位于后面的递增子数组
            //此时最小元素位于中间元素的前面
            else
                R = mid;
        }
        // 此时array[R] > array[L](循环退出), 返回array[L]
        return array[L];
    }

    public int minNumberInRotateArray2(int[] array) {
        int L = 0, R = array.length - 1;
        while (L < R) {
            int mid = L + (R - L) / 2;
            //最小元素在mid后面
            if (array[mid] > array[R])
                L = mid + 1;
            else if (array[mid] == array[R])
                R = R - 1;
            //最小元素在mid前面
            else
                R = mid;
        }
        return array[L];
    }
}