public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0)
            return 0;
        int res = 0;
        // base 当前判断的位数 
        // cur 当前位 
        // height 高位
        int base = 1, cur, height = n;
        while (height > 0) {
            cur = height % 10;
            height /= 10;
            res += height * base;
            if (cur == 1)
                res += (n % base) + 1;
            else if (cur > 1)
                res += base;
            base *= 10;
        }
        return res;
    }
}