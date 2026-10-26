import java.util.Arrays;

class Solution {
    public long maxEarnings(int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));

        long[] dp = new long[n];
        long[] maxPrev = new long[n + 1];
        Arrays.fill(maxPrev, Long.MIN_VALUE / 2); 
        
        long maxTotalEarnings = 0;

        for (int i = 0; i < n; i++) {
            long start = meetings[i][0];
            long end = meetings[i][1];
            long rev = meetings[i][2];

            dp[i] = rev;
            int idx = binarySearch(meetings, i - 1, start);
            
            if (idx != -1) {
                dp[i] = Math.max(dp[i], rev + start + maxPrev[idx + 1]);
            }

            maxTotalEarnings = Math.max(maxTotalEarnings, dp[i]);
            long val = dp[i] - end;
            maxPrev[i + 1] = Math.max(maxPrev[i], val);
        }

        return maxTotalEarnings;
    }

    private int binarySearch(int[][] meetings, int high, long targetStart) {
        int low = 0, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (meetings[mid][1] <= targetStart) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}