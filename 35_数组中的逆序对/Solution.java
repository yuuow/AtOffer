public class Solution {

    private final int mod = 1000000007;

    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1)
            return 0;
        return mergeRec(array, 0, array.length - 1);
    }

    private int mergeRec(int[] arr, int L, int R) {
        if (L == R)
            return 0;
        int mid = L + (R - L) / 2;
        return (mergeRec(arr, L, mid) + mergeRec(arr, mid + 1, R) + merge(arr, L, mid, R)) % mod;
    }

    private int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int k = 0, sum = 0;
        int p1 = L, p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            if (arr[p1] <= arr[p2])
                help[k++] = arr[p1++];
            else {
                sum += (mid - p1 + 1);
                sum %= mod;
                help[k++] = arr[p2++];
            }
        }
        while (p1 <= mid)
            help[k++] = arr[p1++];
        while (p2 <= R)
            help[k++] = arr[p2++];
        for (int i = 0; i < help.length; i++)
            arr[L + i] = help[i];
        return sum;
    }
}