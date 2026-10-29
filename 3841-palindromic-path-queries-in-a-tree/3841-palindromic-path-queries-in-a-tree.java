class Solution {
    private List<Integer>[] tree;
    private int[] depth, parent, heavy, head, pos, treePos;
    private int curPos;
    private int[] segTree;
    private char[] chars;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        chars = s.toCharArray();
        depth = new int[n];
        parent = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        treePos = new int[n];
        Arrays.fill(heavy, -1);

        dfs(0, -1);
        decompose(0, 0);

        segTree = new int[4 * n];
        build(1, 0, n - 1);

        List<Boolean> answer = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                chars[u] = c;
                update(1, 0, n - 1, pos[u], 1 << (c - 'a'));
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int mask = queryPath(u, v);
                answer.add(mask == 0 || (mask & (mask - 1)) == 0);
            }
        }
        return answer;
    }

    private int dfs(int v, int p) {
        parent[v] = p;
        int size = 1;
        int maxSubSize = 0;
        for (int c : tree[v]) {
            if (c != p) {
                depth[c] = depth[v] + 1;
                int subSize = dfs(c, v);
                size += subSize;
                if (subSize > maxSubSize) {
                    maxSubSize = subSize;
                    heavy[v] = c;
                }
            }
        }
        return size;
    }

    private void decompose(int v, int h) {
        head[v] = h;
        pos[v] = curPos;
        treePos[curPos++] = 1 << (chars[v] - 'a');
        if (heavy[v] != -1) {
            decompose(heavy[v], h);
        }
        for (int c : tree[v]) {
            if (c != parent[v] && c != heavy[v]) {
                decompose(c, c);
            }
        }
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            segTree[node] = treePos[l];
            return;
        }
        int mid = (l + r) / 2;
        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);
        segTree[node] = segTree[node * 2] ^ segTree[node * 2 + 1];
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            segTree[node] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) update(node * 2, l, mid, idx, val);
        else update(node * 2 + 1, mid + 1, r, idx, val);
        segTree[node] = segTree[node * 2] ^ segTree[node * 2 + 1];
    }

    private int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) return 0;
        if (ql <= l && r <= qr) return segTree[node];
        int mid = (l + r) / 2;
        return query(node * 2, l, mid, ql, qr) ^ query(node * 2 + 1, mid + 1, r, ql, qr);
    }

    private int queryPath(int u, int v) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u; u = v; v = temp;
            }
            res ^= query(1, 0, chars.length - 1, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }
        if (depth[u] > depth[v]) {
            int temp = u; u = v; v = temp;
        }
        res ^= query(1, 0, chars.length - 1, pos[u], pos[v]);
        return res;
    }
}