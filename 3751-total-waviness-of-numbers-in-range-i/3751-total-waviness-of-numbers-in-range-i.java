public class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for (int i = num1; i <= num2; i++) {
            total += getWaviness(i);
        }
        return total;
    }

    private int getWaviness(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        if (len < 3) {
            return 0;
        }
        int waviness = 0;
        for (int i = 1; i < len - 1; i++) {
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);
            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                waviness++;
            }
        }
        return waviness;
    }
}