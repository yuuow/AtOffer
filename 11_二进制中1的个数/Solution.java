public class Solution {
    // 方法一 不能处理负数，陷入死循环
    public int NumberOf1I(int n) {
        int sum = 0;
        while (n != 0) {
            if ((n & 1) != 0)
                sum++;
            n >>= 1;
        }
        return sum;
    }

    // 方法二 运用一个独立的变量 another
    public int NumberOf1II(int n) {
        int sum = 0;
        int another = 1;
        while (anthor != 0) {
            if ((n & another) != 0)
                sum++;
            another <<= 1;
        }
        return sum;
    }

    // 方法三 找出规律 最优解
    public int NumberOf1III(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }
}