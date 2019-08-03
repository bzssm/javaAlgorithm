import java.util.Collections;
import java.util.PriorityQueue;

public class 数据流中位数KeepTrackingOnMediumOfDataStream {
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {
        数据流中位数KeepTrackingOnMediumOfDataStream ins = new 数据流中位数KeepTrackingOnMediumOfDataStream();
        ins.insert(2);
        System.out.println(ins.getMedian());
        ins.insert(4);
        System.out.println(ins.getMedian());
        ins.insert(3);
        System.out.println(ins.getMedian());
        ins.insert(1);
        System.out.println(ins.getMedian());
        ins.insert(5);
        System.out.println(ins.getMedian());
        ins.insert(6);
        System.out.println(ins.getMedian());
    }

    public void insert(int n) {
        if (minHeap.size() == maxHeap.size()) {
            minHeap.add(n);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(n);
            minHeap.add(maxHeap.poll());
        }
    }

    public double getMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}
