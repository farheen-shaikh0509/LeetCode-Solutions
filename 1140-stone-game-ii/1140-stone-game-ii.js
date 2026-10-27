/**
 * @param {number[]} piles
 * @return {number}
 */
var stoneGameII = function(piles) {
    let n = piles.length;
    let suffixSum = new Array(n + 1).fill(0);
    for (let i = n - 1; i >= 0; i--) {
        suffixSum[i] = suffixSum[i + 1] + piles[i];
    }
    
    let memo = Array.from({ length: n }, () => new Array(n + 1).fill(-1));
    
    function dfs(i, m) {
        if (i >= n) {
            return 0;
        }
        if (2 * m >= n - i) {
            return suffixSum[i];
        }
        if (memo[i][m] !== -1) {
            return memo[i][m];
        }
        
        let maxStones = 0;
        for (let x = 1; x <= 2 * m; x++) {
            maxStones = Math.max(maxStones, suffixSum[i] - dfs(i + x, Math.max(m, x)));
        }
        
        memo[i][m] = maxStones;
        return maxStones;
    }
    
    return dfs(0, 1);
};