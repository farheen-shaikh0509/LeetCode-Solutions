import java.util.Arrays;

class Solution {
    public int maximumAND(int[] nums, int k, int m) {
        int n = nums.length;
        long maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        maxVal += k;
   
        int mx = 64 - Long.numberOfLeadingZeros(maxVal);
        
        int ans = 0;
        long[] cost = new long[n];
        for (int bit = mx - 1; bit >= 0; bit--) {
            int target = ans | (1 << bit);

            for (int i = 0; i < n; i++) {
                int x = nums[i];
                int diff = target & ~x;

                if (diff == 0) {
                    cost[i] = 0;
                } else {
                    int j = 32 - Integer.numberOfLeadingZeros(diff);
                    int mask = (1 << j) - 1;
                    cost[i] = (long) (target & mask) - (x & mask);
                }
            }
            Arrays.sort(cost);
            long totalCost = 0;
            for (int i = 0; i < m; i++) {
                totalCost += cost[i];
            }
            if (totalCost <= k) {
                ans = target;
            }
        }

        return ans;
    }
}