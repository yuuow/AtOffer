import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int pLow = 1, pHight = 2;
        while (pHight > pLow) {

            //连续序列之和 (a1+an)*n/2
            int cur = (pHight + pLow) * (pHight - pLow + 1) / 2;

            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = pLow; i <= pHight; i++)
                    list.add(i);
                res.add(list);
                pLow++;
            } else if (cur < sum) {
                pHight++;
            } else {
                pLow++;
            }
        }
        return res;
    }

}