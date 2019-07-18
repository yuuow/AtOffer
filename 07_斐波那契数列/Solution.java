public class Solution {
    //第一种 递归求解
    public int Fibonacci1(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    //第二种 记忆化(本质还是递归)
    public int[] dp;

    public int Fibonacci2(int n) {
        dp = new int[n + 1];
        return rec(n);
    }

    public int rec(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        if (dp[n] != 0)
            return dp[n];
        dp[n] = rec(n - 1) + rec(n - 2);
        return dp[n];
    }

    //第三种 递推(DP)
    public int Fibonacci3(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    //第四种 滚动优化
    public int Fibonacci(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int f1 = 1;
        int f2 = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }
}