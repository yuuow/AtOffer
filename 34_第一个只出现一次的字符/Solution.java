import java.util.HashMap;

public class Solution {
    public int FirstNotRepeatingChar1(String str) {
        if (str == null || str.length() == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        for (int i = 0; i < str.length(); i++)
            if (map.get(str.charAt(i)) == 1)
                return i;
        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        if (str == null || str.length() == 0)
            return -1;
        int[] counts = new int[58];
        for (int i = 0; i < str.length(); i++)
            counts[str.charAt(i) - 'A']++;
        for (int i = 0; i < str.length(); i++)
            if (counts[str.charAt(i) - 'A'] == 1)
                return i;
        return -1;
    }
}