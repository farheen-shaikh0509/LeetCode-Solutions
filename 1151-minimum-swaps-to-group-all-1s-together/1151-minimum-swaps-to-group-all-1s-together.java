import java.util.Arrays;

class Solution {
    public int minSwaps(int[] data) {
        int totalOnes = 0;
        for (int num : data) {
            if (num == 1) {
                totalOnes++;
            }
        }
        if (totalOnes <= 1) {
            return 0;
        }
        int currentOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (data[i] == 1) {
                currentOnes++;
            }
        }

        int maxOnes = currentOnes;
        for (int i = totalOnes; i < data.length; i++) {
            if (data[i - totalOnes] == 1) {
                currentOnes--;
            }
            if (data[i] == 1) {
                currentOnes++;
            }
            maxOnes = Math.max(maxOnes, currentOnes);
        }

        return totalOnes - maxOnes;
    }
}