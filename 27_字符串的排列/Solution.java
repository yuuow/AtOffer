import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    //方法一
    private ArrayList<String> res;

    public ArrayList<String> Permutation1(String str) {
        res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        rec1(str.toCharArray(), 0);
        Collections.sort(res);
        return res;
    }

    private void rec1(char[] str, int cur) {
        if (cur == str.length - 1) {
            if (!res.contains(String.valueOf(str)))
                res.add(String.valueOf(str));
        } else {
            for (int i = cur; i < str.length; i++) {
                swap(str, cur, i);
                rec1(str, cur + 1);
                swap(str, cur, i); //还原位置(保证进入下一次循环时，序列没有被改变)
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    //方法二
    public ArrayList<String> Permutation2(String str) {
        res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr); //注意这里需要排序，虽然牛客网的可以通过，但是有问题
        rec2(charArr, 0);
        return res;
    }

    private void rec2(char[] str, int cur) {
        char[] newStr = Arrays.copyOf(str, str.length);// 这里是数组的拷贝，然后后面就不要swap了...
        if (cur == newStr.length - 1) {
            res.add(String.valueOf(newStr));
        } else
            for (int i = cur; i < newStr.length; i++) {
                if (cur != i && newStr[cur] == newStr[i])
                    continue;
                swap(newStr, cur, i);
                rec2(newStr, cur + 1);
                //swap(newStr,cur,i);  //这里不能交换，不然得不到字典序
            }
    }

    //方法三
    public ArrayList<String> Permutation3(String str) {
        res = new ArrayList<>();
        if (str == null || str.length() == 0)
            return res;
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr); //保证相邻的元素在一块
        dfs(new StringBuilder(), charArr, new boolean[str.length()]);
        return res;
    }

    private void dfs(StringBuilder sb, char[] str, boolean[] used) {
        if (sb.length() == str.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if (used[i] || (i > 0 && !used[i - 1] && str[i] == str[i - 1]))//去重
                continue;
            used[i] = true;
            sb.append(str[i]);
            dfs(sb, str, used);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}