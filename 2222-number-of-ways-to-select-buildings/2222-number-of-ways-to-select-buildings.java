class Solution {
    public long numberOfWays(String s) {
        long total0 = 0;
        long total1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                total0++;
            } else {
                total1++;
            }
        }
        
        long count0 = 0; 
        long count1 = 0; 
        long ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
          
                ans += count1 * (total1 - count1);
                count0++;
            } else {
                
                ans += count0 * (total0 - count0);
                count1++;
            }
        }
        
        return ans;
    }
}