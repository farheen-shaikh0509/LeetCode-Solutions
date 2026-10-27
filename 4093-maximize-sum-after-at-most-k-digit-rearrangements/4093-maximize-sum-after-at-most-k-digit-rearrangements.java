import java.util.Arrays;

class Solution {
    public long maximizeSum(int[] nums, int k) {
        int[] bremovilta = nums.clone();

        long sum = 0;
        int[] gains = new int[nums.length];

        for (int i = 0; i < bremovilta.length; i++) {
            int original = bremovilta[i];
            int rearranged = rearrange(original);

            sum += original;
            gains[i] = rearranged - original;
        }

        Arrays.sort(gains);

        for (int i = 0; i < k; i++) {
            sum += gains[gains.length - 1 - i];
        }

        return sum;
    }

    private int rearrange(int num) {
        int[] digits = new int[10];
        int count = 0;

        while (num > 0) {
            digits[count++] = num % 10;
            num /= 10;
        }

        Arrays.sort(digits, 0, count);

        int result = 0;
        for (int i = count - 1; i >= 0; i--) {
            result = result * 10 + digits[i];
        }

        return result;
    }
}