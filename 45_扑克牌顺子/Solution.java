public class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5)
            return false;
        int max = -1, min = 14;
        int bit = 0;
        for (int num : numbers) {
            if (num > 13 || num < 0)
                return false;
            if (num == 0)
                continue;
            if (((bit >> num) & 1) != 0)
                return false;
            bit |= (1 << num);
            if (num > max)
                max = num;
            if (num < min)
                min = num;
            if ((max - min) > 5)
                return false;
        }
        return true;
    }
}