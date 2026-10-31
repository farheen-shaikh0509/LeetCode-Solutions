class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        
        int maxTime = 0;
        int n = jobs.length;
        
        for (int i = 0; i < n; i++) {
            int time = (jobs[i] + workers[i] - 1) / workers[i];
            maxTime = Math.max(maxTime, time);
        }
        
        return maxTime;
    }
}