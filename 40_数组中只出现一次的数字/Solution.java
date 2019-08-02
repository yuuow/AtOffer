//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length < 2)
            return;
        int res = 0;
        for (int i = 0; i < array.length; i++)
            res ^= array[i];
        int digit = 1;
        while ((digit & res) == 0)
            digit *= 2;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & digit) == 0)
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }
}