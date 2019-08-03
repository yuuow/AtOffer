public class Solution {
    public String ReverseSentence1(String str) {
        if (str.trim().equals(""))
            return str;
        StringBuilder sb = new StringBuilder();
        String[] strs = str.split(" ");
        for (int i = strs.length - 1; i > 0; i--)
            sb.append(strs[i]).append(" ");
        sb.append(strs[0]);
        return sb.toString();
    }

    //方法二
    public String ReverseSentence2(String str) {
        if (str.trim().equals(""))
            return str;
        int n = str.length();
        char[] chs = str.toCharArray();
        // 1. 先翻转整个字符串
        reverse(chs, 0, n - 1);

        for (int i = 0; i < n;) {
            // 跳过空格 
            while (i < n && chs[i] == ' ')
                i++;
            int L = i, R = i;
            for (; i < n && chs[i] != ' '; i++, R++)
                ;
            // 2. 再反转单个单词
            reverse(chs, L, R - 1);
        }
        return new String(chs);

    }

    private void reverse(char[] chs, int L, int R) {
        for (; L < R; L++, R--) {
            char c = chs[L];
            chs[L] = chs[R];
            chs[R] = c;
        }
    }
}