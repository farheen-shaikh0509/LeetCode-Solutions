class Solution {
    public int minPartitions(String n) {
        if (n == null || n.isEmpty()) {
            return 0;
        }

        int maxDigit = 0;
        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - '0';
            if (digit > maxDigit) {
                maxDigit = digit;
            }
        }

        return maxDigit;
    }
}