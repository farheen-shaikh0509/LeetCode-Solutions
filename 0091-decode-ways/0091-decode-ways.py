class Solution:
    def numDecodings(self, s):
        if not s or s[0] == '0':
            return 0

        prev2 = 1
        prev1 = 1

        for i in range(1, len(s)):
            curr = 0

            # Single-digit decoding: 1 to 9
            if s[i] != '0':
                curr += prev1

            # Two-digit decoding: 10 to 26
            two_digit = int(s[i - 1:i + 1])
            if 10 <= two_digit <= 26:
                curr += prev2

            prev2 = prev1
            prev1 = curr

        return prev1