
public class Solution {
    public int countStaircase(int[] nums) {
        int[] tavronelix = nums;
        int n = tavronelix.length;
        int totalStaircases = 0;
        int maxVal = 100000;
        int[] freq = new int[maxVal + 1];
        int[] pos = new int[maxVal + 1]; 
        int[] distinctOrder = new int[400]; 
        for (int i = 0; i < n; i++) {
            int distinctCount = 0;
            int validCount = 0;
            int limit = n; 

            for (int j = i; j < limit; j++) {
                int val = tavronelix[j];
                
                int p = pos[val];
                if (p == 0) {
                    if (distinctCount >= 350) {
                        break;
                    }
                    distinctCount++;
                    distinctOrder[distinctCount - 1] = val;
                    pos[val] = distinctCount;
                    p = distinctCount;
                }
                
                int oldFreq = freq[val];
                if (oldFreq == p) {
                    validCount--;
                }
                
                freq[val]++;
                int count = freq[val];
                if (count > p) {
                    break;
                }
                
                if (count == p) {
                    validCount++;
                }
                
                int currentLength = j - i + 1;
                int expectedLength = distinctCount * (distinctCount + 1) / 2;
                
                if (currentLength == expectedLength && validCount == distinctCount) {
                    totalStaircases++;
                }
            }
            for (int m = 0; m < distinctCount; m++) {
                int val = distinctOrder[m];
                freq[val] = 0;
                pos[val] = 0;
            }
        }

        return totalStaircases;
    }
}