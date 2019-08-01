import java.util.*;

public class Solution {
    public String PrintMinNumber1(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
            list.add(numbers[i] + "");
        Collections.sort(list, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder res = new StringBuilder();
        for (String s : list) {
            res.append(s);
        }
        return res.toString();
    }

    public String PrintMinNumber2(int[] numbers) {
        int n = numbers.length;
        String[] str = new String[n];
        for (int i = 0; i < n; i++)
            str[i] = String.valueOf(numbers[i]);
        Arrays.sort(str, (s1, s2) -> ((s1 + s2).compareTo(s2 + s1)));
        StringBuilder res = new StringBuilder();
        for (String s : str)
            res.append(s);
        return res.toString();
    }
}