public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0)
            return false;
        boolean[] used = new boolean[length];
        for (int num : numbers) {
            if (used[num]) {
                duplication[0] = num;
                return true;
            }
            used[num] = true;
        }
        return false;
    }

    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0)
            return false;
        for (int i = 0; i < length; i++) {
            int index = Math.abs(numbers[i]);
            if (numbers[index] >= 0)
                numbers[index] = -numbers[index];
            else {
                duplication[0] = index;
                return true;
            }
        }
        return false;
    }
}