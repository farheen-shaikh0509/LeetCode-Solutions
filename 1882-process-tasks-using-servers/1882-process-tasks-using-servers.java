class Solution {
public int[] assignTasks(int[] servers, int[] tasks) {

    int n = servers.length;
    int m = tasks.length;
    PriorityQueue<int[]> available = new PriorityQueue<>(
        (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        }
    );
    PriorityQueue<long[]> busy = new PriorityQueue<>(
        (a, b) -> {
            if (a[0] != b[0])
                return Long.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        }
    );
    for (int i = 0; i < n; i++) {
        available.offer(new int[]{servers[i], i});
    }
    int[] ans = new int[m];
    long time = 0;
    int task = 0;
    while (task < m) {
        while (!busy.isEmpty() && busy.peek()[0] <= time) {
            long[] s = busy.poll();
            available.offer(new int[]{
                (int) s[1],
                (int) s[2]
            });
        }
        if (available.isEmpty()) {
            time = busy.peek()[0];
            continue;
        }
        // Assign all waiting tasks while servers are available.
        while (task < m && !available.isEmpty() && task <= time) {
            int[] server = available.poll();
            int weight = server[0];
            int index = server[1];
            ans[task] = index;
            busy.offer(new long[]{
                time + tasks[task],
                weight,
                index
            });
            task++;
        }
        time++;
    }
    return ans;
}

}