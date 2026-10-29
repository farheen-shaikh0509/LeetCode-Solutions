
class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length;
        long[] dp = new long[n];
        Deque<Integer> stack = new ArrayDeque<>();
        long maxBooks = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && books[stack.peek()] >= books[i] - (i - stack.peek())) {
                stack.pop();
            }

            int j = stack.isEmpty() ? -1 : stack.peek();
            int lastTook = books[i] - (i - j) + 1;
            if (lastTook > 1) {
                dp[i] = (long) (books[i] + lastTook) * (i - j) / 2;
            } else {
                dp[i] = (long) books[i] * (books[i] + 1) / 2;
            }
            if (j >= 0) {
                dp[i] += dp[j];
            }

            stack.push(i);
            maxBooks = Math.max(maxBooks, dp[i]);
        }

        return maxBooks;
    }
}