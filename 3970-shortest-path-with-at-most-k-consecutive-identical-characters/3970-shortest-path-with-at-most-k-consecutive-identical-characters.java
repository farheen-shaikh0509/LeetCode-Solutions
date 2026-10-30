import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }
                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
    
        Map<String, Integer> visited = new HashMap<>();
        
        char startChar = labels.charAt(0);
        pq.offer(new int[]{0, 0, 1, startChar});
        visited.put("0_" + startChar + "_1", 0);
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            int count = curr[2];
            char lastChar = (char) curr[3];
            
            if (u == n - 1) {
                return cost;
            }
            
            String stateKey = u + "_" + lastChar + "_" + count;
            if (cost > visited.getOrDefault(stateKey, Integer.MAX_VALUE)) {
                continue;
            }
            
            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                char nextChar = labels.charAt(v);
                
                int nextCount = (nextChar == lastChar) ? count + 1 : 1;
                
                if (nextCount <= k) {
                    int nextCost = cost + weight;
                    String nextStateKey = v + "_" + nextChar + "_" + nextCount;
                    
                    if (nextCost < visited.getOrDefault(nextStateKey, Integer.MAX_VALUE)) {
                        visited.put(nextStateKey, nextCost);
                        pq.offer(new int[]{nextCost, v, nextCount, nextChar});
                    }
                }
            }
        }
        
        return -1;
    }
}