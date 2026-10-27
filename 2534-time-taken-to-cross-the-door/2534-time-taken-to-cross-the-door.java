class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int n = arrival.length;
        int[] ans = new int[n];
        Deque<Integer>[] q = new Deque[2];
        q[0] = new ArrayDeque<>();
        q[1] = new ArrayDeque<>();
        
        int t = 0; 
        int i = 0; 
        int st = 1;
        
        while (i < n || !q[0].isEmpty() || !q[1].isEmpty()) {
            while (i < n && arrival[i] <= t) {
                q[state[i]].offer(i);
                i++;
            }
                        if (q[0].isEmpty() && q[1].isEmpty()) {
                t = arrival[i];
                continue;
            }
            
            if (!q[0].isEmpty() && !q[1].isEmpty()) {
                ans[q[st].peek()] = t;
                q[st].poll();
            } else if (!q[0].isEmpty()) {
                st = 0;
                ans[q[0].peek()] = t;
                q[0].poll();
            } else {
                st = 1;
                ans[q[1].peek()] = t;
                q[1].poll();
            }
                        t++;

            if (q[0].isEmpty() && q[1].isEmpty() && i < n && arrival[i] > t) {
                st = 1;
            }
        }
        
        return ans;
    }
}