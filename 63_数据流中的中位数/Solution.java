import java.util.PriorityQueue;

public class Solution {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public void Insert(Integer num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);
        if (minHeap.size() - maxHeap.size() > 1)
            maxHeap.add(minHeap.poll());
        else if (maxHeap.size() - minHeap.size() > 1)
            minHeap.add(maxHeap.poll());

    }

    public Double GetMedian() {
        if (minHeap.size() > maxHeap.size())
            return 1.0 * minHeap.peek();
        else if (maxHeap.size() > minHeap.size())
            return 1.0 * maxHeap.peek();
        else
            return 1.0 * (minHeap.peek() + maxHeap.peek()) / 2;
    }

}