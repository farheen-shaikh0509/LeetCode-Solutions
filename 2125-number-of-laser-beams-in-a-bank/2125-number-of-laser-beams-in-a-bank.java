public class Solution {
    public int numberOfBeams(String[] bank) {
        if (bank == null || bank.length == 0) {
            return 0;
        }

        int totalBeams = 0;
        int prevCount = 0;

        for (String row : bank) {
            int currentCount = 0;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '1') {
                    currentCount++;
                }
            }

            if (currentCount > 0) {
                totalBeams += prevCount * currentCount;
                prevCount = currentCount;
            }
        }

        return totalBeams;
    }
}