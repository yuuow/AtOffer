import java.util.*;

public class Solution {

    static ArrayList<Integer> nums;

    static {
        nums = new ArrayList<>();
        for (int a = 0; a < Integer.MAX_VALUE; a *= 2)
            for (int b = a; b < Integer.MAX_VALUE; b *= 3)
                for (int c = b; c < Integer.MAX_VALUE; c *= 5)
                    nums.add((int) c);
        Collections.sort(nums);
    }

    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 1;
        return nums.get(index - 1);
    }
}