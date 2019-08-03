public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.trim().equals(""))
            return 0;
        char[] chs = str.trim().toCharArray();
        int res = 0;
        for (int i = (chs[0] == '-' || chs[0] == '+') ? 1 : 0; i < str.length(); i++) {
            if (chs[i] < '0' || chs[i] > '9')
                return 0;
            int num = chs[i] - '0';
            int sum = res * 10 + num;
            // if ((sum - num) / 10 != res)
            // return 0;
            res = sum;
        }
        return chs[0] == '-' ? -res : res;
    }
}