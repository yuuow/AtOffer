public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int L = firstEqual(array, k);
        int R = lastEqual(array, k);
        if (L != -1 && R != -1)
            return R - L + 1;
        return 0;
    }

    //找到最后一个
    private int firstEqual(int[] arr, int key) {
        int L = 0, R = arr.length - 1;
        int mid;
        while (L <= R) {
            mid = L + (R - L) / 2;
            if (arr[mid] >= key)
                R = mid - 1;
            else
                L = mid + 1;
        }
        if (L <= arr.length - 1 && arr[L] == key)
            return L;
        return -1;
    }

    //找到最后一个
    private int lastEqual(int[] arr, int key) {
        int L = 0, R = arr.length - 1;
        int mid;
        while (L <= R) {
            mid = L + (R - L) / 2;
            if (arr[mid] <= key)
                L = mid + 1;
            else
                R = mid - 1;
        }
        if (R >= 0 && arr[R] == key)
            return R;
        return -1;
    }
}