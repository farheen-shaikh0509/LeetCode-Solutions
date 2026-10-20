import java.util.Arrays;

class Solution {
    public long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, (a, b) -> Integer.compare(a[0], b[0]));

        int n = coins.length;
        long ans = 0;

        ans = Math.max(ans, solve(coins, k));

        int[][] reversed = new int[n][3];

        for (int i = 0; i < n; i++) {
            reversed[i][0] = -coins[n - 1 - i][1];
            reversed[i][1] = -coins[n - 1 - i][0];
            reversed[i][2] = coins[n - 1 - i][2];
        }

        ans = Math.max(ans, solve(reversed, k));

        return ans;
    }

    private long solve(int[][] coins, int k) {
        int n = coins.length;
        long ans = 0;
        long sum = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            long left = coins[i][0];
            long right = left + k - 1L;

            while (j < n && coins[j][1] <= right) {
                sum += (long) (coins[j][1] - coins[j][0] + 1)
                        * coins[j][2];
                j++;
            }

            long current = sum;

            if (j < n && coins[j][0] <= right) {
                current += (right - coins[j][0] + 1) * coins[j][2];
            }

            ans = Math.max(ans, current);

            if (j > i) {
                sum -= (long) (coins[i][1] - coins[i][0] + 1)
                        * coins[i][2];
            } else {
                j = i + 1;
            }
        }

        return ans;
    }
}