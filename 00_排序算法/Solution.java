class Solution {
    static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        boolean flag;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    flag = ture;
                }
            }
            if (!flag)
                break;
        }
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (minIndex != i)
                swap(arr, i, minIndex);
        }
    }

    public static void insertSort1(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i;
            int target = arr[i];
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
    }

    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--)
                swap(arr, j - 1, j);
        }
    }

    public static void shellSort1(int[] arr) {
        int incre = arr.length;
        while (true) {
            incre = incre / 2;
            for (int k = 0; k < incre; k++) {
                for (int i = k + incre; i < arr.length; i += incre) {
                    for (int j = i; j > k; j -= incre) {
                        if (arr[j] < arr[j - incre])
                            swap(arr, j, j - incre);
                        else
                            break;
                    }
                }
            }
            if (incre == 1)
                break;
        }
    }

    public static void shellSort2(int[] arr) {
        int len = arr.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        quickProcess(arr, 0, arr.length - 1);
    }

    static void quickProcess(int[] arr, int L, int R) {
        if (L >= R)
            return;
        int p = partition(arr, L, R);
        quickProcess(arr, L, p - 1);
        quickProcess(arr, p + 1, R);
    }

    /**
    * 对arr[l...r]部分进行partition操作
    * 返回p, 使得arr[L...p-1] < arr[p] ; arr[p+1...R] > arr[p]
    */
    static int partition(int[] arr, int L, int R) {
        //直接选取 arr[L] 作为 pivot(中心点)
        int key = arr[L];
        int pivot = L;
        for (int i = L + 1; i <= R; i++) {
            if (arr[i] < key)
                swap(arr, i, ++pivot);
        }
        // 将arr[L]放到pivot位置(中间) --> 完全了按照arr[L]划分数组的目的
        swap(arr, pivot, L);
        return pivot;
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        mergeProcess(arr, 0, arr.length - 1);
    }

    static void mergeProcess(int[] arr, int L, int R) {
        if (L >= R)
            return;
        int mid = L + ((R - L) >> 1);
        mergeProcess(arr, L, mid);
        mergeProcess(arr, mid + 1, R);
        /**这个是一个优化，因为arr[L,mid]和arr[mid+1,R]已经有序，
         * 所以如果满足这个条件，就不要排序了,防止一开始数组有序*/
        if (arr[mid] > arr[mid + 1])
            merge(arr, L, mid, R);
    }

    static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int k = 0;
        int p1 = L, p2 = mid + 1;
        while (p1 <= mid && p2 <= R)
            help[k++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        while (p1 <= mid)
            help[k++] = arr[p1++];
        while (p2 <= R)
            help[k++] = arr[p2++];
        for (int i = 0; i < k; i++)
            arr[i + L] = help[i];
    }
}