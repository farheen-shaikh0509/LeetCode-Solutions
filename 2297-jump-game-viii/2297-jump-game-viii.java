class Solution {
    public long minCost(int[] nums, int[] costs) {
        int n = nums.length;
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0; 
        Deque<Integer> maxStack = new ArrayDeque<>();
        Deque<Integer> minStack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!maxStack.isEmpty() && nums[i] >= nums[maxStack.peek()]) {
                dp[i] = Math.min(dp[i], dp[maxStack.pop()] + costs[i]);
            }
            while (!minStack.isEmpty() && nums[i] < nums[minStack.peek()]) {
                dp[i] = Math.min(dp[i], dp[minStack.pop()] + costs[i]);
            }
            
            maxStack.push(i);
            minStack.push(i);
        }
        
        return dp[n - 1];
    }
}