import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int L = 0, R = array.length - 1;
        while (L < R) {
            if (array[L] + array[R] > sum)
                R--;
            else if (array[L] + array[R] < sum)
                L++;
            else {
                res.add(array[L]);
                res.add(array[R]);
                return res;
            }
        }
        return res;
    }
}