from collections import Counter


class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        if not s:
            return True
        counts = Counter(s)
        odd_count = sum(1 for count in counts.values() if count % 2 != 0)
        return odd_count <= 1