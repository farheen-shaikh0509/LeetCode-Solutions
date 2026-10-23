class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char task : tasks){
            freq[task - 'A']++;
        }
        int maxfreq = 0;
        for(int count : freq){
            maxfreq = Math.max(maxfreq, count);
        }
        int maxCount = 0;
        for(int count : freq){
            if(count == maxfreq){
maxCount++;

            }

        }

int intervals = (maxfreq - 1) * (n + 1) + maxCount;
    return Math.max(tasks.length, intervals);
        
    }
}