class Solution {
    private static final int MOD = 1_000_000_007;
    static class Node{
        int l, r;
        long sum;
        long sumSq;
        long lazy;

    } 

    private Node[] tree;
    
    public int sumCounts(int[] nums) {
        
        int n = nums.length;
        tree = new Node[4 * n];
        build(1, 0, n - 1);

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSumSq = 0;
        for (int r = 0; r < n; r++) {
            int p = lastSeen.getOrDefault(nums[r], -1);
            modify(1, p + 1, r, 1);
            totalSumSq = (totalSumSq + tree[1].sumSq) % MOD;
            lastSeen.put(nums[r], r);

        }
        return (int) totalSumSq;

    }
    private void build(int u, int l, int r){
        tree[u] = new Node();
        tree[u].l = l;
        tree[u].r = r;
        if (l == r) return;

        int mid = l + (r - l) / 2;
        build(2 * u, l, mid);
        build(2 * u + 1, mid + 1, r);


    }

    private void apply(int u, long val) {
        long len = tree[u].r - tree[u].l + 1;
        tree[u].sumSq = (tree[u].sumSq  + 2 * val * tree[u].sum % MOD  + val * val % MOD * len % MOD) % MOD;               
        tree[u].sum = (tree[u].sum + val * len) % MOD;
        tree[u].lazy = (tree[u].lazy + val) % MOD;

    }

private void pushDown(int u){
    if (tree[u].lazy != 0) {
            apply(2 * u, tree[u].lazy);
            apply(2 * u + 1, tree[u].lazy);
            tree[u].lazy = 0;
        }


}

private void pushUp(int u){
    tree[u].sum = (tree[2 * u].sum + tree[2 * u + 1].sum) % MOD;
    tree[u].sumSq = (tree[2 * u].sumSq + tree[2 * u + 1].sumSq) % MOD;

}

private void modify(int u, int l, int r, long val) {
        if (tree[u].l >= l && tree[u].r <= r) {
            apply(u, val);
            return;
        }
        pushDown(u);
        int mid = tree[u].l + (tree[u].r - tree[u].l) / 2;
        if (l <= mid) modify(2 * u, l, r, val);
        if (r > mid) modify(2 * u + 1, l, r, val);
        pushUp(u);

}
}