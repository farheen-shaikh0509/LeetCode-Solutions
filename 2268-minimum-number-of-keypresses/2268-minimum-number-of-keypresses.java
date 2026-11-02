
class Solution {
    public int minimumKeypresses(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        
        int totalKeypresses = 0;
        int multiplier = 1;
        for (int i = 1; i <= 26; i++) {
            totalKeypresses += multiplier * freq[26 - i];
            if (i % 9 == 0) {
                multiplier++;
            }
        }
        
        return totalKeypresses;
    }
}