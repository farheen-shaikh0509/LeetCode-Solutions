import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
private PriorityQueue<Integer> small; 
private PriorityQueue<Integer> large; // Min

 public MedianFinder() {
 small = new PriorityQueue<>(Collections.reverseOrder());     large = new PriorityQueue<>(); }

public void addNum(int num) {
 small.offer(num);
// Move the largest element from small to large.
  large.offer(small.poll());
// Balance the heaps
 if (small.size() < large.size()) {
 small.offer(large.poll());
        }
    }
    public double findMedian() {
   if (small.size() > large.size()) {
            return small.peek();
        }

        return ((double) small.peek() + large.peek()) / 2.0;
    }
}