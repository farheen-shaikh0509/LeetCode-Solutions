class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] h : highways) {
            int u = h[0], v = h[1], w = h[2];
            graph[u].add(new int[] {v, w});
            graph[v].add(new int[] {u, w});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, 0, 0});
        
        int[][] dist = new int[n][discounts + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            int k = curr[2];
            
            if (u == n - 1) {
                return cost;
            }
            
            if (cost > dist[u][k]) {
                continue;
            }
            
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int w = neighbor[1];
                
                if (cost + w < dist[v][k]) {
                    dist[v][k] = cost + w;
                    pq.offer(new int[] {dist[v][k], v, k});
                }
                
                if (k < discounts && cost + w / 2 < dist[v][k + 1]) {
                    dist[v][k + 1] = cost + w / 2;
                    pq.offer(new int[] {dist[v][k + 1], v, k + 1});
                }
            }
        }
        
        return -1;
    }
}