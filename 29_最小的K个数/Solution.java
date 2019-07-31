import java.util.*;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length)
            return res;

        PriorityQueue<Integer> maxHead = new PriorityQueue<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if ((Integer) o1 <= (Integer) o2)
                    return 1;
                else
                    return -1;
            }
        });

        for (int i = 0; i < input.length; i++) {
            if (maxHead.size() < k) {
                maxHead.add(input[i]);
            } else if (input[i] < maxHead.peek()) {
                maxHead.poll();
                maxHead.add(input[i]);
            }
        }

        for (Integer item : maxHead) {
            res.add(item);
        }
        return res;
    }
}