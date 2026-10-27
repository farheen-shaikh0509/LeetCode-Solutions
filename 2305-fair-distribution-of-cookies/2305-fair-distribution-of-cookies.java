class Solution {
    private int ans = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        dfs(0, cookies, new int[k], k);
        return ans;
    }

    private void dfs(int idx, int[] cookies, int[] children, int k) {
        if (idx == cookies.length) {
            int max = 0;
            for (int c : children) {
                max = Math.max(max, c);
            }
            ans = Math.min(ans, max);
            return;
        }

        for (int i = 0; i < k; i++) {
            if (children[i] + cookies[idx] >= ans) {
                continue;
            }
            children[i] += cookies[idx];
            dfs(idx + 1, cookies, children, k);
            children[i] -= cookies[idx];
            if (children[i] == 0) {
                break;
            }
        }
    }
}