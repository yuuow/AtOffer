public class Solution {
    //方法一 字符串拼接
    public String LeftRotateString1(String str, int n) {
        if (str == null || str.length() == 0)
            return "";
        if (n == str.length() || n == 0)
            return str;
        StringBuilder res = new StringBuilder(str.substring(n));
        res.append(str.substring(0, n));
        return res.toString();
    }

    //方法二 字符串反转
    private void reverse(char[] chs, int L, int R) {
        for (; L < R; L++, R--) {
            char c = chs[L];
            chs[L] = chs[R];
            chs[R] = c;
        }
    }

    public String LeftRotateString2(String str, int n) {
        if (str == null || str.length() == 0)
            return "";
        if (str.length() == 1 || str.length() == n)
            return str;
        char[] chs = str.toCharArray();
        reverse(chs, 0, n - 1);
        reverse(chs, n, str.length() - 1);
        reverse(chs, 0, str.length() - 1);
        return new String(chs);
    }
}