public class Solution {
    public String replaceSpace(StringBuffer str) {
        int spaceNums = 0; //记录空格的数量
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                spaceNums++;
        }
        int oldLength = str.length() - 1; //原始长度
        int newLength = str.length() + 2 * spaceNums - 1; //扩充长度
        str.setLength(newLength + 1);

        while (oldLength >= 0) {
            if (str.charAt(oldLength) == ' ') {
                str.setCharAt(newLength--, '0');
                str.setCharAt(newLength--, '2');
                str.setCharAt(newLength--, '%');
            } else {
                str.setCharAt(newLength--, str.charAt(oldLength));
            }
            oldLength--;
        }
        return str.toString();

    }
}
