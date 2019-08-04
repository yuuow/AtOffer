import java.util.ArrayList;

public class Solution {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        int mul = 1;
        for (int i = 0; i < n; i++) {
            B[i] = nul;
            mul *= A[i];
        }
        mul = 1;
        for (int i = n - 1; i >= 0; i--) {
            B[i] *= mul;
            mul *= A[i];
        }
        return B;

    }
}