public class Solution {

    private int[][] dp;

    public boolean match(char[] str, char[] pattern) {
        dp = new int[str.length + 1][pattern.length + 1];
        return isMatch(str, pattern, str.length, pattern.length);
    }

    private boolean isMatch(char[] s, char[] p, int ls, int lp) {
        if (ls == 0 && lp == 0)
            return true;
        if (dp[ls][lp] != 0)
            return dp[ls][lp] == 1;
        if (lp == 0)
            return false;
        boolean res = false;
        if (ls == 0) {
            res = lp >= 2 && p[lp - 1] == '*' && isMatch(s, p, ls, lp - 2);
        } else {
            if (p[lp - 1] == '.' || p[lp - 1] == s[ls - 1]) {
                res = isMatch(s, p, ls - 1, lp - 1);
            } else if (p[lp - 1] == '*') {
                if (p[lp - 2] == '.')
                    res = isMatch(s, p, ls - 1, lp - 1) || isMatch(s, p, ls - 1, lp) || isMatch(s, p, ls, lp - 2);
                else if (s[ls - 1] == p[lp - 2]) {
                    res = isMatch(s, p, ls - 1, lp - 2) //这里和上面不同，不是ls-1, lp-1, 
                            || isMatch(s, p, ls - 1, lp) || isMatch(s, p, ls, lp - 2);
                } else
                    //p[lp - 2] != '.' && s[ls - 1] != p[lp - 2] a*匹配0次
                    res = isMatch(s, p, ls, lp - 2);
            }
        }
        dp[ls][lp] = res ? 1 : -1;
        return res;
    }
}