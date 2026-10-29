
class Solution {
    public int kBigIndices(int[] nums, int k) {
        int n = nums.length;
        if (n < 2 * k + 1) {
            return 0;
        }

        boolean[] leftValid = new boolean[n];
        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < n; i++) {
            if (leftMaxHeap.size() == k && leftMaxHeap.peek() < nums[i]) {
                leftValid[i] = true;
            }

            leftMaxHeap.offer(nums[i]);
            if (leftMaxHeap.size() > k) {
                leftMaxHeap.poll();
            }
        }

        int count = 0;
        PriorityQueue<Integer> rightMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = n - 1; i >= 0; i--) {
            if (rightMaxHeap.size() == k && rightMaxHeap.peek() < nums[i]) {
                if (leftValid[i]) {
                    count++;
                }
            }

            rightMaxHeap.offer(nums[i]);
            if (rightMaxHeap.size() > k) {
                rightMaxHeap.poll();
            }
        }

        return count;
    }
}