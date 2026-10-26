import java.util.*;

class FirstUnique {
    private Map<Integer, Integer> countMap;
    private Queue<Integer> queue;
    public FirstUnique(int[] nums) {
        countMap = new HashMap<>();
        queue = new LinkedList<>();
        for (int num : nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        while (!queue.isEmpty() && countMap.get(queue.peek()) > 1) {
            queue.poll();
        }
                if (queue.isEmpty()) {
            return -1;
        }
        
        return queue.peek();
    }
    
    public void add(int value) {
        countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        queue.offer(value);
    }
}