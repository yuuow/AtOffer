public class Solution {
    //方法一 暴力法
    public double Power1(double base, int exponent) {
        long N = exponent;
        if (N < 0) {
            base = 1 / base;
            N = -N;
        }
        double ans = 1;
        for (int i = 0; i < N; i++)
            ans = ans * base;
        return ans;
    }

    //方法二 递归
    public double fastPow(double base, long exponent) {
        if (exponent == 0)
            return 1.0;
        double half = fastPow(base, exponent / 2);
        if (exponent % 2 == 0)
            return half * half;
        else
            return half * half * base;
    }

    public double Power2(double base, int exponent) {
        long N = exponent;
        if (N < 0) {
            base = 1 / base;
            N = -N;
        }

        return fastPow(base, N);
    }

    //方法三 快速幂算法
    public double Power3(double base, int exponent) {
        int N = exponent;
        if (N < 0) {
            base = 1 / base;
            N = -N;
        }
        double ans = 1;
        double current_product = base;
        for (int i = N; i > 0; i /= 2) {
            if ((i % 2) == 1)
                ans = ans * current_product;
            current_product *= current_product;
        }
        return ans;
    }
}