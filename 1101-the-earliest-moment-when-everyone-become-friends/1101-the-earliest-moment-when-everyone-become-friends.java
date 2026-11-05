class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int[] log : logs) {
            int x = find(parent, log[1]);
            int y = find(parent, log[2]);

            if (x != y) {
                if (rank[x] < rank[y]) {
                    parent[x] = y;
                } else if (rank[x] > rank[y]) {
                    parent[y] = x;
                } else {
                    parent[y] = x;
                    rank[x]++;
                }

                components--;

                if (components == 1) {
                    return log[0];
                }
            }
        }

        return -1;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }
}