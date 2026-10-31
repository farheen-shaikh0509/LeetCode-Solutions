class Solution {
    public int uniquePaths(int[][] grid) {
        int MOD = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;
        long[][] dp = new long[n + 1][2];
    
        dp[1][0] = 1;
        dp[1][1] = 1;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int colIdx = c + 1;
                
                if (grid[r][c] == 1) {
                    long nextRight = dp[colIdx][1];
                    long nextDown = dp[colIdx - 1][0];
                    dp[colIdx][0] = nextRight;
                    dp[colIdx][1] = nextDown;
                } else {
                    long sum = (dp[colIdx][1] + dp[colIdx - 1][0]) % MOD;
                    dp[colIdx][0] = sum;
                    dp[colIdx][1] = sum;
                }
            }
        }
        
        return (int) dp[n][0];
    }
}