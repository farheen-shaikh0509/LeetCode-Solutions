
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int in = nums[right];
            currentSum += in;
            freq.put(in, freq.getOrDefault(in, 0) + 1);
            if (right - left + 1 > k) {
                int out = nums[left];
                currentSum -= out;
                freq.put(out, freq.get(out) - 1);
                if (freq.get(out) == 0) {
                    freq.remove(out);
                }
                left++;
            }
      
            if (right - left + 1 == k && freq.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        
        return maxSum;
    }
}